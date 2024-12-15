package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    private static final double INIT_UNIT_OXYGEN_BILOGIST=70;

    private static final double INIT_DECREACES=5;


    public Biologist(String name) {
        super(name, INIT_UNIT_OXYGEN_BILOGIST);
    }

    @Override
    public void breath() {
        setOxygen(getOxygen() -INIT_DECREACES );
    }
}
