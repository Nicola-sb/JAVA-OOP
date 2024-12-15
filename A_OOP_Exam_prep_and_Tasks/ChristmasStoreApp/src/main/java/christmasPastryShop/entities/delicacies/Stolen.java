package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy{

//The Stolen has a constant value for InitialStolenPortion – 250.
    private static final double INITAL_STOLEN_PORTION=250;

    public Stolen(String name,double price) {
        super(name, INITAL_STOLEN_PORTION, price);
    }
}
