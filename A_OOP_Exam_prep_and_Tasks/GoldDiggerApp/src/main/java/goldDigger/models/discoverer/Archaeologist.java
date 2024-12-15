package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{

    private static final double INIT_POINT_ENERGY_ARCHEOLOGIST=60;
    public Archaeologist(String name) {
        super(name, INIT_POINT_ENERGY_ARCHEOLOGIST);
    }
}
