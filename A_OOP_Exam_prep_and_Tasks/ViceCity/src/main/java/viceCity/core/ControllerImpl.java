package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.common.ExceptionMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player tommyVercety;
    private Map<String,Player>civilPlayer;
    private Deque<Gun>gunsDeque;
    private Neighbourhood neighbourhood;
    private static final int TOMMY_MAX_HEALTH=100;




    public ControllerImpl() {
        tommyVercety=new MainPlayer();
        civilPlayer=new LinkedHashMap<>();
        gunsDeque=new ArrayDeque<>();
        neighbourhood=new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {

        Player player=new CivilPlayer(name);
        civilPlayer.put(name,player);

        return String.format(ConstantMessages.PLAYER_ADDED,name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type){
            case "Pistol":
                gun=new Pistol(name);
                break;
            case "Rifle":
                gun=new Rifle(name);
                break;
            default:
                return String.format(ConstantMessages.GUN_TYPE_INVALID);
        }
        gunsDeque.offer(gun);
        return String.format(ConstantMessages.GUN_ADDED,name,type);
    }

    @Override
    public String addGunToPlayer(String playerName) {
        //•	name – String (player's name)
        //Functionality
        //Adds the first added gun to the player's gun repository.
        //•	If there are no guns in the queue, return the following message:
        //"There are no guns in the queue!"
        //•	If the name of the player is "Vercetti", you need to add the gun to the main player's repository and return the following message:
        //"Successfully added {gun name} to the Main Player: Tommy Vercetti"
        //•	If you receive a name that doesn't exist, you should return the following message:
        //"Civil player with that name doesn't exists!"
        //•	If everything is successful, you should add the gun to the player's repository and return the following message:
        //"Successfully added {gun name} to the Civil Player: {player name}"
        Gun gunToAdd=gunsDeque.poll();//Вече имам първото оръжие,което съм добавил

        if(gunToAdd==null){
            return GUN_QUEUE_IS_EMPTY;
        }
        if(playerName.equals("Vercetti")){
            tommyVercety.getGunRepository().add(gunToAdd);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,gunToAdd.getName(),tommyVercety.getName());
        }
        //Трябва да проверя дали имам такъв цивилен с това име(playerName)
        Player civilPlayerFind=civilPlayer.get(playerName);
        if(civilPlayerFind==null){
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        civilPlayerFind.getGunRepository().add(gunToAdd);

        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,gunToAdd.getName(),playerName);
    }

    @Override
    public String fight() {
             neighbourhood.action(tommyVercety,civilPlayer.values());

             if(tommyVercety.getLifePoints()==TOMMY_MAX_HEALTH && civilPlayer.values().stream().allMatch(player -> player.getLifePoints()==50)){
                 return FIGHT_HOT_HAPPENED;
             }
//             if(tommyVercety.getLifePoints()==100){
//                 boolean everyoneIsInMaxHealth=true;
//                 for (Player value : civilPlayer.values()) {
//                        if(value.getLifePoints() < 50){
//                            everyoneIsInMaxHealth=false;
//                        }
//                 }
//                 if(everyoneIsInMaxHealth){
//                     return FIGHT_HOT_HAPPENED;
//                 }
//             }
        List<Player>deadPlayer=civilPlayer.values().stream().filter(player -> !player.isAlive()).collect(Collectors.toList());

//             StringBuilder stringBuilder=new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
//             stringBuilder.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,tommyVercety.getLifePoints())).append(System.lineSeparator());
//             stringBuilder.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadPlayer.size())).append(System.lineSeparator());
//             stringBuilder.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,civilPlayer.size()-deadPlayer.size()));
        StringBuilder output=new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator()).
                append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,tommyVercety.getLifePoints())).append(System.lineSeparator()).
                append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadPlayer.size())).append(System.lineSeparator()).
                append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,civilPlayer.size()-deadPlayer.size()));

        for (Player deadPlayer1 : deadPlayer) {
            civilPlayer.remove(deadPlayer1.getName());
        }

           return output.toString();
    }
}
