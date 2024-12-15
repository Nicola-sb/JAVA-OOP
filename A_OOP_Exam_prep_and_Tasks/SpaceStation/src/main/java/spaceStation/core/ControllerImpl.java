package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exlporedPlanets;

    public ControllerImpl() {
        astronautRepository=new AstronautRepository();
        planetRepository=new PlanetRepository();
        exlporedPlanets=0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        //Creates an astronaut with the given name of the given type. If the astronaut is invalid, throw an IllegalArgumentException with a message:
        //"Astronaut type doesn't exists!"
        //The method should return the following message:
        //•	"Successfully added {astronautType}: {astronautName}!"
        Astronaut astronaut;
        switch (type){
            case "Biologist":
                astronaut=new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut=new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut=new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED,type,astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        //Creates a planet with the provided items and name.
        //The method should return the following message:
        //•	"Successfully added Planet: {planetName}!"
        Planet planet=new PlanetImpl(planetName);
//        for (String item : items) {
//            planet.getItems().add(item);
//        }
        List<String>itemsList= Arrays.asList(items);
        planet.getItems().addAll(itemsList);
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        //Retires the astronaut from the space station by removing it from its repository.
        // If an astronaut with that name doesn't exist, throw IllegalArgumentException with the following message:
        //•	"Astronaut {astronautName} doesn't exists!"
        // If an astronaut is successfully retired, remove it from the repository and return the following message:
        //•	"Astronaut {astronautName} was retired!"
        if(this.astronautRepository.getModels().stream().noneMatch(astronaut -> astronaut.getName().equals(astronautName))){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST,astronautName));
        }

        Astronaut astronautToRemove=astronautRepository.findByName(astronautName);
        astronautRepository.remove(astronautToRemove);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED,astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        //•	You call each of the astronauts and pick only the ones that have oxygen above 60 units.
        //•	You send suitable astronauts on a mission to explore the planet.
        //•	If you don't have any suitable astronauts, throw IllegalArgumentException with the following message:
        // "You need at least one astronaut to explore the planet!"
        //•	After a mission, you must return the following message, with the name of the explored planet and the count
        // of the astronauts that had given their lives for the mission:
        //"Planet: {planetName} was explored! Exploration finished with {deadAstronauts} dead astronauts!"
        List<Astronaut>astronautListAbove60Units=astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if(astronautListAbove60Units.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        int countBeforeMission=astronautListAbove60Units.size();
        Mission mission=new MissionImpl();
        Planet planet=planetRepository.findByName(planetName);
        mission.explore(planet,astronautListAbove60Units);
//        List<Astronaut>deadAstrounauts=astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen()==0).collect(Collectors.toList());
        int countAfterMission=astronautListAbove60Units.size();
        exlporedPlanets++;

        return String.format(ConstantMessages.PLANET_EXPLORED,planetName,countBeforeMission-countAfterMission);
    }

    @Override
    public String report() {
        //Returns the information about the astronauts. If any of them doesn't have bag items, print "none" instead:
        //"{exploredPlanetsCount} planets were explored!
        //Astronauts info:
        //Name: {astronautName One}
        //Oxygen: {astronautOxygen One}
        //Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ none}
        //…
        //Name: {astronautName N}
        //Oxygen: {astronautOxygen N}
        //Bag items: {bagItem1, bagItem2, bagItem3, …, bagItemn \ none}"
        StringBuilder sb=new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED,exlporedPlanets)).append(System.lineSeparator());
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut currensAstronaut : astronautRepository.getModels()) {
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME,currensAstronaut.getName())).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN,currensAstronaut.getOxygen())).append(System.lineSeparator());
            if(currensAstronaut.getBag().getItems().isEmpty()){
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,"None"));
            }else{
                sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                        String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,currensAstronaut.getBag().getItems())));
            }
        }

        return sb.toString().trim();
    }
}
