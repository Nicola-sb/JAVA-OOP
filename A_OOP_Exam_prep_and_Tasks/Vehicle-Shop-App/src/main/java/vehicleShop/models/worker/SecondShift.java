package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{

//Initial strength units: 70.
//The method working() decreases the workers' strength by additional 5 units.
//The constructor should take the following values upon initialization:
//(String name)
    private static final int INITIAL_STRENGHT_SECOND=70;

    public SecondShift(String name) {
        super(name, INITIAL_STRENGHT_SECOND);
    }

    @Override
    public void working() {
        setStrength(getStrength() - 5);
    }
}
