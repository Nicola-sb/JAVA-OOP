package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{
//Initial strength units: 100.
//The constructor should take the following values upon initialization:
//(String name)
    private static final int INITIAL_STRENGHT_FIRSTSHIFT=100;

    public FirstShift(String name) {
        super(name, INITIAL_STRENGHT_FIRSTSHIFT);
    }
}
