package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectedCounts;
    public ControllerImpl() {
     discovererRepository=new DiscovererRepository();
     spotRepository=new SpotRepository();
     inspectedCounts=0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        //Creates a discoverer with the given name of the given kind and saves it in the repository.
        // If the kind is invalid, throw an IllegalArgumentException with the following message:
        //"Discoverer kind doesn't exists."
        //Otherwise, the method should return the following message:
        //•	"Added {kind}: {discovererName}."
        Discoverer discoverer;
        switch (kind){
            case "Anthropologist":
                discoverer=new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer=new Geologist(discovererName);
                break;
            case "Archaeologist":
                discoverer=new Archaeologist(discovererName);
                break;
            default:
                throw  new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED,kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        //Creates a spot with the provided exhibits and name and save it in the repository.
        //The method should return the following message:
        //•	"Added spot: {spotName}."
        Spot spot=new SpotImpl(spotName);
        for (String currentExhibit : exhibits) {
            spot.getExhibits().add(currentExhibit);
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        //Exclude the discoverer from diggings by removing them from the repository.
        // If a discoverer with that name doesn’t exist, throw IllegalArgumentException with the following message:
        //•	"Discoverer {discovererName} doesn't exists."
        // If a discoverer is successfully excluded, remove them from the repository and return the following message:
        //•	"Discoverer {discovererName} has excluded!"
        Discoverer discoverer=discovererRepository.byName(discovererName);
        if(discoverer==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST,discovererName));
        }
        discovererRepository.remove(discoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE,discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        //•	You call each of the discoverers and pick only the ones that have energy above 45 units.
        //•	If you don't have any suitable discoverers, throw an IllegalArgumentException with the following message:
        // "You must have at least one discoverer to inspect the spot."
        //•	After a mission, you must return the following message with
        // the name of the inspected spot and the count of the discoverers that had excluded on the mission:
        //"The spot {spotName} was inspected. {excludedDiscoverer} discoverers have been excluded on this operation."
        List<Discoverer>discoverersAbove45Units=discovererRepository.getCollection().stream().filter(discoverer -> discoverer.getEnergy() > 45).collect(Collectors.toList());
        if(discoverersAbove45Units.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation=new OperationImpl();
        Spot spot=spotRepository.byName(spotName);
        operation.startOperation(spot,discoverersAbove45Units);
        inspectedCounts++;
        List<Discoverer>excludedDiscovers=discovererRepository.getCollection().stream().filter(discoverer -> discoverer.getEnergy()==0).collect(Collectors.toList());

        return String.format(ConstantMessages.INSPECT_SPOT,spotName,excludedDiscovers.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT,inspectedCounts)).append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO).append(System.lineSeparator());

        for (Discoverer currentDiscoverer : discovererRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME,currentDiscoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY,currentDiscoverer.getEnergy())).append(System.lineSeparator());
            if(currentDiscoverer.getMuseum().getExhibits().isEmpty()){
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None")).append(System.lineSeparator());
            }else{
                sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,currentDiscoverer.getMuseum().getExhibits())));
            }

        }
        return sb.toString();
    }
}
