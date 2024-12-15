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
import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

     private ExplorerRepository explorerRepository;
     private StateRepository stateRepository;
     private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository=new ExplorerRepository();
        this.stateRepository=new StateRepository();
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
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
            explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state=new StateImpl(stateName);
        for (String currentExhibit : exhibits) {
            state.getExhibits().add(currentExhibit);
        }
//        Collections.addAll(state.getExhibits(),exhibits);
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
        //•	You call each of the explorers and pick only the ones that have energy above 50 units.
        //•	If you don't have any suitable explorers, throw an IllegalArgumentException with the following message:
        // "You must have at least one explorer to explore the state."
        //•	After a mission, you must return the following message with the name of the explored state and the count of the explorers that had retired on the mission:
        //"The state {stateName} was explored. {retiredExplorers} researchers have retired on this mission."
        List<Explorer>explorersAbove50Units=explorerRepository.getCollection().stream().filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());
        if(explorersAbove50Units.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission=new MissionImpl();
//        State state=new StateImpl(stateName);
        State state=stateRepository.byName(stateName);
        mission.explore(state,explorersAbove50Units);
        exploredStates++;
//        List<Explorer>retiredExplorers=explorersAbove50Units.stream().filter(explorer -> explorer.getEnergy() == 0).collect(Collectors.toList());
        long retiredExplorers=explorersAbove50Units.stream().filter(explorer -> explorer.getEnergy()==0).count();
        return String.format(ConstantMessages.STATE_EXPLORER,stateName,retiredExplorers);
    }

    @Override
    public String finalResult() {
//        //finalResulta вика toStringa на repository,който вика toString на explorer
//        StringBuilder sb=new StringBuilder();
//        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED,exploredStates)).append(System.lineSeparator());
//        sb.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());
//        //Сега трябва да преминем през всеки един изследовател,неговото име,енергия и списък с експонати
//        sb.append(explorerRepository.toString());
//
//           return sb.toString().trim();
        StringBuilder sb=new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED,exploredStates)).append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        sb.append(explorerRepository.toString());
       return sb.toString().trim();
    }
}
