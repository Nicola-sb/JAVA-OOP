package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer{

    private static final double INIT_POINT_ENERGY_ANTROPOLOGIST=40;

    public Anthropologist(String name) {
        super(name, INIT_POINT_ENERGY_ANTROPOLOGIST);
    }
}
