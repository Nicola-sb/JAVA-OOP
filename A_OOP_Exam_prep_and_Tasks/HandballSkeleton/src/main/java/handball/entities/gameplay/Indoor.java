package handball.entities.gameplay;

public class Indoor extends BaseGameplay{

    private static final int CAPACITY_FOR_INDOOR=250;

    public Indoor(String name) {
        super(name, CAPACITY_FOR_INDOOR);
    }
}
