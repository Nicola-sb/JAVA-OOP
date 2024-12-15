package handball.entities.gameplay;

import handball.common.ExceptionMessages;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseGameplay implements Gameplay{

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team>teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipments=new ArrayList<>();
        this.teams=new ArrayList<>();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEquipments(Collection<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }

    @Override
    public int allProtection() {
        //Returns the sum of each equipment’s protection in the Gameplay.
       int sum=0;
        for (Equipment equipment : equipments) {
            sum+=equipment.getProtection();
        }
        return sum;
    }

    @Override
    public void addTeam(Team team) {
//Adds a Team on the Team. No need to check for empty space.
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
     this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
//Adds an Equipment in the Gameplay.
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
      //The teamsInGameplay() method calls all teams to play in the gameplay.
        for (Team team : teams) {
            team.play();
        }
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        //Returns a String with information about the Gameplay in the format below. If the Gameplay doesn't have a team, print "none" instead.
        //"{gameplayName} {gameplayType}
        //Team: {teamName1} {teamName2} (…) / Team: none
        //Equipment: {equipmentsCount}, Protection: {allProtection}"

//        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d\n",
//                        this.name, this.getClass().getSimpleName(),
//                        this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")),
//                        this.equipments.size(), allProtection());

        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%s %s",name,getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Team: %s",this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")))).append(System.lineSeparator());
        sb.append(String.format("Equipment: %d, Protection: %d",this.equipments.size(),allProtection()));

           return sb.toString().trim();
    }
}
