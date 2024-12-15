package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double INITIAL_UNITS_OF_ENERGY=60;
    private static final double INIT_POINTS_DECREASE_NATURAL=7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

    @Override
    public void search() {
        setEnergy(Math.max(0,getEnergy()-INIT_POINTS_DECREASE_NATURAL));
//        setEnergy(getEnergy() - INIT_POINTS_DECREASE_NATURAL);
    }
}
