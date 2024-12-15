package FootballTeamGeneratorAlone;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //name: String
    //players: List<Player>
    //Team (String)
    //setName(String) : void
    //getName(): String

    private String name;
    private List<Player>players;

    public Team(String name) {
        setName(name);
        players=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    //addPlayer(Player) : void
    //removePlayer(String) : void
    //getRating() : double
    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(String playerName){
        boolean isPlayerForRemove=players.removeIf(player ->  player.getName().equals(playerName));
        if(!isPlayerForRemove){
            String exceptionRemove=String.format("Player %s is not in %s team.",playerName,name);
            throw new IllegalArgumentException(exceptionRemove);
        }

    }
    public double getRating(){
      return   players.stream().mapToDouble(player -> player.overallSkillLevel()).average().orElse(0);
    }

}
