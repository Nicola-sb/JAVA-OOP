package viceCity.models.players;

public class CivilPlayer extends BasePlayer{

    private static final int START_HEALTH=50;


    public CivilPlayer(String name) {
        super(name, START_HEALTH);
    }
}
