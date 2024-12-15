package FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 66 ot 100

        String input=scanner.nextLine();
        Map<String,Team>teamsMap=new LinkedHashMap<>();
        while (!"END".equals(input)){
            try{
                String[]commandsParts=input.split(";");
                String commandName=commandsParts[0];
                String teamName=commandsParts[1];

                switch (commandName){
                    case "Team":
                        Team team=new Team(teamName);
                        teamsMap.put(teamName,team);
                        break;
                    case "Add":
                        String playerName=commandsParts[2];
                        int endurance = Integer.parseInt(commandsParts[3]);
                        int sprint = Integer.parseInt(commandsParts[4]);
                        int dribble = Integer.parseInt(commandsParts[5]);
                        int passing = Integer.parseInt(commandsParts[6]);
                        int shooting = Integer.parseInt(commandsParts[7]);

                        if(!teamsMap.containsKey(teamName)){
                            System.out.printf("Team %s does not exist.", teamName);
                        }else{
                            Player player =new Player(playerName,endurance,sprint,dribble,passing,shooting);
                            teamsMap.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove=commandsParts[2];

                        teamsMap.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if(!teamsMap.containsKey(teamName)){
                            System.out.printf("Team %s does not exist.", teamName);
                        }else{
                            System.out.printf("%s - %d%n",teamName,Math.round(teamsMap.get(teamName).getRating()));
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
