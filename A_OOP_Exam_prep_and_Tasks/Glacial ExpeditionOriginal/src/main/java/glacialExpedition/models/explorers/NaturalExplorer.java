package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

//Has 60 initial units of energy.
//The search() method should decrease the explorer's energy by 7 units.
//The constructor should take the following values upon an initialization:
//String name
    private static double INITIAL_ENERGY=60;
    private static final double INITIAL_EXLORER_SEARCH_ENERGY=7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        setEnergy(Math.max(0,getEnergy()-INITIAL_EXLORER_SEARCH_ENERGY));
//        INITIAL_ENERGY=INITIAL_ENERGY-7;
//        if(INITIAL_ENERGY < 0){
//            INITIAL_ENERGY=Math.max(0,INITIAL_ENERGY-7);
//        }
    }
}
