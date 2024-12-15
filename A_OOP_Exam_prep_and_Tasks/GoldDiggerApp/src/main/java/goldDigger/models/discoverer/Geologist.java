package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{

    private static final double INIT_POINT_ENERGY_ANTROPOLOGIST=100;

    public Geologist(String name) {
        super(name, INIT_POINT_ENERGY_ANTROPOLOGIST);
    }
}
