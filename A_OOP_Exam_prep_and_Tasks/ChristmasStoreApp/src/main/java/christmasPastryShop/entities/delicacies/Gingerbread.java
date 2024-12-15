package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy{

//The Gingerbread has a constant value for InitialGingerbreadPortion – 200.
    private static final double INITIAL_GINGER_PORTION=200;
    public Gingerbread(String name, double price) {
        super(name, INITIAL_GINGER_PORTION, price);
    }
}
