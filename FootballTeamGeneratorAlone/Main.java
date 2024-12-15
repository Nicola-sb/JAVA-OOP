package FootballTeamGeneratorAlone;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        Map<String,Team>teamMap=new LinkedHashMap<>();
        while (!"END".equals(input)){

                String[]inputData=input.split(";");
                String command=inputData[0];
                String teamName=inputData[1];
                //Team;{TeamName}" – add a new team
                //•	"Add;{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}" – add a new player to the team
                //•	"Remove;{TeamName};{PlayerName}" – remove the player from the team
                //•	"Rating;{TeamName}" – print the team rating, rounded to the closest integer
                   try{
                       switch (command){
                           case "Team":

                               Team team = new Team(teamName);
                               teamMap.put(teamName, team);

                               break;
                           case "Add":
                               //•	If you receive a command to add a player to a missing team, print: "Team {team name} does not exist

                               String playerNameToAdd=inputData[2];
                               int endurance=Integer.parseInt(inputData[3]);
                               int sprint=Integer.parseInt(inputData[4]);
                               int dribble=Integer.parseInt(inputData[5]);
                               int passing=Integer.parseInt(inputData[6]);
                               int shooting=Integer.parseInt(inputData[7]);

                               if(!teamMap.containsKey(teamName)){
                                   System.out.printf("Team %s does not exist%n",teamName);
                               }else{
                                   Player player=new Player(playerNameToAdd,endurance,sprint,dribble,passing,shooting);
                                   teamMap.get(teamName).addPlayer(player);
                               }
                               break;
                           case "Remove":
                               //•	If you receive a command to remove a missing player, print: "Player {Player name} is not in {Team name} team

                               String playerNameToRemove=inputData[2];
                               if(!teamMap.containsKey(teamName)){
                                   System.out.printf("Team %s does not exist.%n", teamName);
                               }else{
                                   teamMap.get(teamName).removePlayer(playerNameToRemove);
                               }

                               break;
                           case "Rating":
                               if(!teamMap.containsKey(teamName)){
                                   System.out.printf("Team %s does not exist.%n", teamName);
                               }else{
                                   System.out.printf("%s - %d%n",teamName,Math.round(teamMap.get(teamName).getRating()));
                               }
                               break;
                       }
                   }catch (IllegalArgumentException e){
                       System.out.println(e.getMessage());
                   }
            input=scanner.nextLine();
        }


        }
}
