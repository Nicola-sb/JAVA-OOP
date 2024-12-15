package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.FINAL_EXPLORER_INFO;
import static glacialExpedition.common.ConstantMessages.FINAL_STATE_EXPLORED;

public class ControllerImpl implements Controller {

     private ExplorerRepository explorerRepository;
     private StateRepository stateRepository;
     private int exploredStates;
    public ControllerImpl() {
          explorerRepository=new ExplorerRepository();
          stateRepository=new StateRepository();
          exploredStates=0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "AnimalExplorer":
                explorer=new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer=new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer=new NaturalExplorer(explorerName);
                break;
            default:
                throw  new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state=new StateImpl(stateName);

//        for (String exhibitToAdd : exhibits) {
//            state.getExhibits().add(exhibitToAdd);
//        }
        Collections.addAll(state.getExhibits(),exhibits);
        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer=explorerRepository.byName(explorerName);
        if(explorer==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer>explorersAbove50Units=explorerRepository.getCollection().stream().filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());
        if(explorersAbove50Units.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state=stateRepository.byName(stateName);
        Mission mission=new MissionImpl();
        mission.explore(state,explorersAbove50Units);
        exploredStates++;
        long countOfTiredExplorerds=explorersAbove50Units.stream().filter(explorer -> explorer.getEnergy() ==0).count();

        return String.format(ConstantMessages.STATE_EXPLORER,stateName,countOfTiredExplorerds);
    }

    @Override
    public String finalResult() {
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append(String.format(FINAL_STATE_EXPLORED,exploredStates)).append(System.lineSeparator());
        stringBuilder.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        stringBuilder.append(explorerRepository.toString().trim());

        return stringBuilder.toString().trim();

    }

}
