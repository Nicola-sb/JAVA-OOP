package handball.entities.equipment;

public class ElbowPad extends BaseEquipment{


    private static final int PROTECTION_FOR_ELBOW=90;
    private static final double PRICE_FOR_ELBOW=25;

    public ElbowPad() {
        super(PROTECTION_FOR_ELBOW, PRICE_FOR_ELBOW);
    }
}
