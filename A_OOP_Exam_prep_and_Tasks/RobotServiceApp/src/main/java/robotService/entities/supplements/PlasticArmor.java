package robotService.entities.supplements;

public class PlasticArmor extends BaseSupplement{

    //The plastic armor has a hardness of 1 and a price of 10.
    //Note: The Constructor should take no values upon initialization
    private static final int HARNDESS_PLASTIC_ARMOR=1;
    private static final double PRICE_PLASTIC_ARMOR=10;

    public PlasticArmor() {
        super(HARNDESS_PLASTIC_ARMOR, PRICE_PLASTIC_ARMOR);
    }
}
