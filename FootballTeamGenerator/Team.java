package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //-	name: String
    //-	players: List<Player>
    //+ 	Team (String)
    //-	setName(String) : void
    //+	getName(): String
    //+	addPlayer(Player) : void
    //+	removePlayer(String) : void
    //+	getRating() : double
    private String name;
    private List<Player>players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //+	addPlayer(Player) : void
    //+	removePlayer(String) : void
    //+	getRating() : double
    public void addPlayer(Player player){
        players.add(player);

    }
    public void removePlayer(String playerName){
       boolean isRemoved= players.removeIf(player -> player.getName().equals(playerName));
       if(!isRemoved){
           String exceptionRemove=String.format("Player %s is not in %s team.",playerName,name);
           throw new IllegalArgumentException(exceptionRemove);
       }
    }
    //A team should expose a name, a rating (calculated by the average skill level of all players in the team),
    // and methods for adding and removing players.
    public double getRating(){//Трябва да бъде средният рейтинг на всички играчи
        //Трябва да си ги вземем,да ги мапнем към неговия скил левъл,за да можем да имаме стрийм от Double
        //и му искаме avverage,а ако няма да върне 0 (казваме orElse в случай,че няма нито един играч в отбора)
         return  players.stream().mapToDouble(player -> player.overallSkillLevel()).average().orElse(0);
    }
}
