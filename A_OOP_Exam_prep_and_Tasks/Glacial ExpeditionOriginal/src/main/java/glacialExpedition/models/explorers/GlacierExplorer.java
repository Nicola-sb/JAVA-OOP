package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {
    //Has 40 initial units of energy.
    //The constructor should take the following values upon an initialization:
    //String name
    private static double INITAL_UNITS=40;

    public GlacierExplorer(String name) {
        super(name, INITAL_UNITS);
    }

}
