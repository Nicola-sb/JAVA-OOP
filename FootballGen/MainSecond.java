package FootballGen;

import FootballTeamGenerator.Player;
import FootballTeamGenerator.Team;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command=scanner.nextLine();

        Map<String, Team>teamsMap=new LinkedHashMap<>();

        while (!"END".equals(command)){
            //Add;Arsenal;Kieran_Gibbs;75;85;84;92;67
            try {
                String myCommand = command.split(";")[0];
                switch (myCommand) {
                    case "Team":
                        //Team;{TeamName}" – add a new team
                        String teamName = command.split(";")[1];
                        Team team = new Team(teamName);
                        teamsMap.put(teamName, team);
                        break;
                    case "Add":
                        //Add;{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}" – add a new player to the team
                        //•	If you receive a command to add a player to a missing team, print: "Team {team name} does not exist
                        String teamNameToAdd = command.split(";")[1];
                        String playerName = command.split(";")[2];
                        int endurance = Integer.parseInt(command.split(";")[3]);
                        int sprint = Integer.parseInt(command.split(";")[4]);
                        int dribble = Integer.parseInt(command.split(";")[5]);
                        int passing = Integer.parseInt(command.split(";")[6]);
                        int shooting = Integer.parseInt(command.split(";")[7]);
                        if (!teamsMap.containsKey(teamNameToAdd)) {
                            System.out.printf("Team %s does not exist.", teamNameToAdd);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamsMap.get(teamNameToAdd).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        //•	"Remove;{TeamName};{PlayerName}" – remove the player from the team
                        //•	If you receive a command to remove a missing player, print: "Player {Player name} is not in {Team name} team.
                        String teamNameRemove = command.split(";")[1];
                        String playerToRemove = command.split(";")[2];
                        if (!teamsMap.containsKey(teamNameRemove)) {
                            System.out.printf("Team %s does not exist.", teamNameRemove);
                        } else {
                            teamsMap.get(teamNameRemove).removePlayer(playerToRemove);
                        }
                        break;
                    case "Rating":
                        //Rating;{TeamName}" – print the team rating, rounded to the closest integer
                        String teamNameRating = command.split(";")[1];
                        if (!teamsMap.containsKey(teamNameRating)) {
                            System.out.printf("Team %s does not exist.", teamNameRating);
                        } else {
                            System.out.printf("%s - %d", teamNameRating, Math.round(teamsMap.get(teamNameRating).getRating()));
                        }
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            command=scanner.nextLine();
        }
    }
}
