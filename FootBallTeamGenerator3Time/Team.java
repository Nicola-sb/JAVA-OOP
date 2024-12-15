package FootBallTeamGenerator3Time;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //name: String
    //players: List<Player>
    //Team (String)
    //setName(String) : void
    //getName(): String
    //addPlayer(Player) : void
    //removePlayer(String) : void
    //getRating() : double
    private String name;
    private List<Player>players;

    public Team(String name) {
        this.name = name;
        players=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    //addPlayer(Player) : void
    //removePlayer(String) : void
    //getRating() : double
    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(String playerName){
        boolean isRemoved=players.removeIf(playerNa -> playerNa.getName().equals(playerName));

        if(!isRemoved){
            String exceptionRemove=String.format("Player %s is not in %s team.",playerName,name);
            throw new IllegalArgumentException(exceptionRemove);
        }
    }
    //A team should expose a name, a rating (calculated by the average skill level of all players in the team
    public double getRating(){
          return players.stream().mapToDouble(player -> player.overallSkillLevel()).average().orElse(0);
    }
}
