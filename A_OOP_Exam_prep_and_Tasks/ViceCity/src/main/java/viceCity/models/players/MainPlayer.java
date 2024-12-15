package viceCity.models.players;

public class MainPlayer extends BasePlayer{

    private static final String DEFAULT_NAME="Tommy Vercetti";
    private static final int START_HEALTH_POINTS=100;


    public MainPlayer() {
        super(DEFAULT_NAME, START_HEALTH_POINTS);
    }
}
