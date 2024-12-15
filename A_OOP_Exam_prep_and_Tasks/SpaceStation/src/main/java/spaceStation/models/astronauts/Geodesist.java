package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    private static final double INIT_UNIT_OXYGEN_GEODESIST=40;

    public Geodesist(String name) {
        super(name, INIT_UNIT_OXYGEN_GEODESIST);
    }
}
