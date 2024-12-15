package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.BaseGameplay;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;

public class ControllerImpl implements Controller{

    private EquipmentRepository equipment;
    private Map<String,Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment=new EquipmentRepository();
        this.gameplays=new LinkedHashMap<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        //Adds a Gameplay. Valid types are: "Outdoor" and "Indoor".
        //If the Gameplay type is invalid, you have to throw a NullPointerException with the following message:
        //•	"Invalid gameplay type."
        //If the Gameplay is added successfully, the method should return the following String:
        //•	"Successfully added {gameplayType}."
        Gameplay gameplay;
        switch (gameplayType){
            case "Outdoor":
                gameplay=new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay=new Indoor(gameplayName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }
        gameplays.put(gameplayName,gameplay);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE,gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        //Creates equipment of the given type and adds it to the Repository. Valid types are "Kneepad" and "ElbowPad".
        //If the equipment type is invalid, throw an IllegalArgumentException with a message:
        //•	"Invalid equipment type."
        //The method should return the following String if the operation is successful:
        //•	"Successfully added {equipmentType}."
        Equipment currentEquipment;
        switch (equipmentType){
            case "Kneepad":
                currentEquipment=new Kneepad();
                break;
            case "ElbowPad":
                currentEquipment=new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }
        this.equipment.add(currentEquipment);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE,equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        //Adds the desired Equipment to the Gameplay with the given name. You have to remove the Equipment from Repository if the insert is successful.
        //If there is no such equipment, you have to throw an IllegalArgumentException with the following message:
        //•	"There isn't an equipment of type {equpmentType}."
        //If no exceptions are thrown return the String:
        //•	"Successfully added {equpmentType} to {gameplayName}."
        Equipment equipment1=equipment.findByType(equipmentType);
//        Equipment currentEquipment;
//        switch (equipmentType){
//            case "Kneepad":
//                currentEquipment=new Kneepad();
//                break;
//            case "ElbowPad":
//                currentEquipment=new ElbowPad();
//                break;
//            default:
//                currentEquipment=null;
//        }
        if(equipment1==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND,equipmentType));
        }
//        Gameplay gameplay=gameplays.stream().filter(gameplay1 -> gameplay1.getName().equals(gameplayName)).findFirst().get();
//        gameplay.getEquipments().add(currentEquipment);
        equipment.remove(equipment1);
        this.gameplays.get(gameplayName).addEquipment(equipment1);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY,equipmentType,gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        //Check if the team type is valid. Valid Team types are: "Bulgaria", "Germany". Adds the desired Team to the Gameplay with the given name.
        //If the Team type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid team type." - if the Team type is invalid.
        //If no errors are thrown, return one of the following strings:
        //•	"The coverage of the terrain is not suitable." - if the Team cannot play in the Gameplay
        //•	"Successfully added {teamType} to {gameplayName}." - if the Team is added successfully in the Gameplay
        Team teamToAdd;
        switch (teamType){
            case "Bulgaria":
                teamToAdd=new Bulgaria(teamName,country,advantage);
                break;
            case "Germany":
                teamToAdd=new Germany(teamName,country,advantage);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }

        Gameplay gameplay=gameplays.get(gameplayName);
        boolean isSuitable = gameplay.getClass().getSimpleName().equals("Outdoor") && teamType.equals("Bulgaria") ||
                gameplay.getClass().getSimpleName().equals("Indoor") && teamType.equals("Germany");
        gameplays.get(gameplayName).addTeam(teamToAdd);

        if (!isSuitable) {
            return GAMEPLAY_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        //All teams with given name must be on the Gameplay.
        //Returns a string with information about how many teams were successfully played in the following format:
        //•	"Teams that have played: {playedCount}"
        Gameplay gameplay=gameplays.get(gameplayName);
        gameplay.teamsInGameplay();

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        //Calculates the value of the Gameplay with the given name. It is calculated by the sum of all Team’s advantages in the Gameplay.
        //Return a string in the following format:
        //•	"The advantage of Gameplay {gameplayName} is {value}."
           Gameplay gameplay=gameplays.get(gameplayName);
           int sumGameplay= gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();

           return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY,gameplayName,sumGameplay);
    }

    @Override
    public String getStatistics() {
        //Returns information about each gameplay. You can use the overridden .toString() Gameplay method.
        //"{gameplayName} {gameplayType}
        //Team: {teamName1} {teamName2} (…) / Team: none
        //Equipment: {equipmentsCount}, Protection: {allProtection}
        //{gameplayName} {gameplayType}
        //Team: {teamName1} {teamName2} (…) / Team: none
        //Equipment: {equipmentsCount}, Protection: {allProtection}
        //(…)"
        //Note: Use \n or System.lineSeparator() for a new line.
        StringBuilder sb=new StringBuilder();
        this.gameplays.values().forEach(sb::append);
        return sb.toString().trim();
    }
}
