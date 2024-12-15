package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{

    private static final double INIT_UNIT_OXYGEN_GEODESIST=90;

    public Meteorologist(String name) {
        super(name, INIT_UNIT_OXYGEN_GEODESIST);
    }
}
