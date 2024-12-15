package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {

    //Has initial 100 units of energy.
    //The constructor should take the following values upon an initialization:
    //String name
    private static final double INITIAL_UNITS=100;

    public AnimalExplorer(String name) {
        super(name, INITIAL_UNITS);
    }

}
