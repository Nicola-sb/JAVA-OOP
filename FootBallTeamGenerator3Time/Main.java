package FootBallTeamGenerator3Time;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

          String commandInput=scanner.nextLine();
        Map<String,Team>teamMap=new LinkedHashMap<>();
          while (!commandInput.equals("END")){
              String command=commandInput.split(";")[0];
              try{
                  switch (command){
                      case "Team":
                          String teamName=commandInput.split(";")[1];
                          Team team=new Team(teamName);
                          teamMap.put(teamName,team);

                          break;
                      case "Add":
                          //•	"Add;{TeamName};{PlayerName};{Endurance};{Sprint};{Dribble};{Passing};{Shooting}" – add a new player to the team
                          String teamNameToAdd=commandInput.split(";")[1];
                          String playerToAdd=commandInput.split(";")[2];
                          int enduracne=Integer.parseInt(commandInput.split(";")[3]);
                          int sprint=Integer.parseInt(commandInput.split(";")[4]);
                          int dribble=Integer.parseInt(commandInput.split(";")[5]);
                          int passing=Integer.parseInt(commandInput.split(";")[6]);
                          int shooting=Integer.parseInt(commandInput.split(";")[7]);

                          if(!teamMap.containsKey(teamNameToAdd)){
                              System.out.printf("Team %s does not exist.",teamNameToAdd);
                          }else{
                              Player player=new Player(playerToAdd,enduracne,sprint,dribble,passing,shooting);
                              teamMap.get(teamNameToAdd).addPlayer(player);
                          }
                          break;
                      case "Remove":
                          //•	If you receive a command to remove a missing player, print:
                          // "Player {Player name} is not in {Team name} team."
                          //•	"Remove;{TeamName};{PlayerName}" – remove the player from the team
                          String playerNameToRemove=commandInput.split(";")[2];
                          String teamNameToRemove=commandInput.split(";")[1];
                          if(!teamMap.containsKey(teamNameToRemove)){
                              System.out.printf("Team %s does not exist.", teamNameToRemove);
                          }else{
                              teamMap.get(teamNameToRemove).removePlayer(playerNameToRemove);
                          }
                          break;
                      case "Rating":
                          //Rating;{TeamName}" – print the team rating, rounded to the closest integer
                          String teamNameRating=commandInput.split(";")[1];
                          if(!teamMap.containsKey(teamNameRating)){
                              System.out.printf("Team %s does not exist.", teamNameRating);
                          }else{
                              System.out.printf("%s - %d",teamNameRating,Math.round(teamMap.get(teamNameRating).getRating()));
                          }

                          break;
                  }
              }catch (IllegalArgumentException e){
                  System.out.println(e.getMessage());
              }

              commandInput=scanner.nextLine();
          }
    }
}
