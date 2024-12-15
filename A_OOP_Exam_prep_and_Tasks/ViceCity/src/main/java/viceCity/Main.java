package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.EngineImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();

//        Player playerTommy=new MainPlayer();
//        GunRepository tommysGun=new GunRepository();
//        Gun pistol=new Pistol("TommysPistol");
//        Gun rifle=new Pistol("TommysRifle");
//        tommysGun.add(pistol);
//        tommysGun.add(rifle);
//
//        CivilPlayer firstCivilPlayer=new CivilPlayer("Bateto");
//        CivilPlayer secondCivilPlayer=new CivilPlayer("SecondBate");
//        Collection<Player>players=new ArrayDeque<>();
//        players.add(firstCivilPlayer);
//        players.add(secondCivilPlayer);
//        playerTommy.getGunRepository().add(pistol);
//        playerTommy.getGunRepository().add(rifle);
//
//        GangNeighbourhood gangNeighbourhood=new GangNeighbourhood();
//        gangNeighbourhood.action(playerTommy,players);
    }
}
