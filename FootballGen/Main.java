package FootballGen;

import FootballTeamGenerator.Player;
import FootballTeamGenerator.Team;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command=scanner.nextLine();
        Map<String, Team>teams=new LinkedHashMap<>();
        while (!command.equals("END")){
            try {
                String[] commandsParts = command.split(";");
                String currentCommand = commandsParts[0];
                String teamName = commandsParts[1];
                switch (currentCommand) {
                    case "Team":
                        //Team;{TeamName}" – add a new team
                        //•	If you receive a command to show stats for a missing team, print: "Team {team name} does not exist
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        //•	"Add;{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}" – add a new player to the team
                        String playerName = commandsParts[2];
                        int endurance = Integer.parseInt(commandsParts[3]);
                        int sprint = Integer.parseInt(commandsParts[4]);
                        int dribble = Integer.parseInt(commandsParts[5]);
                        int passing = Integer.parseInt(commandsParts[6]);
                        int shooting = Integer.parseInt(commandsParts[7]);
                        //•	If you receive a command to add a player to a missing team, print: "Team {team name} does not exist

//                        String playerException = String.format("Team %s does not exist", teamName);
//                        System.out.println(playerException);

                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }

                        break;
                    case "Remove":
                        String playerToRemove = commandsParts[2];
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.", teamName);
                        } else {
                            teams.get(teamName).removePlayer(playerToRemove);
                        }
                        //•	"Remove;{TeamName};{PlayerName}" – remove the player from the team
                        //•	If you receive a command to remove a missing player, print: "Player {Player name} is not in {Team name} team."

                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.", teamName);
                        } else {
                            System.out.printf("%s - %d", teamName, Math.round(teams.get(teamName).getRating()));
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
