package handball.entities.gameplay;

public class Outdoor extends BaseGameplay{

    private static final int CAPACITY_FOR_OUTDOOR=150;

    public Outdoor(String name) {
        super(name, CAPACITY_FOR_OUTDOOR);
    }
}
