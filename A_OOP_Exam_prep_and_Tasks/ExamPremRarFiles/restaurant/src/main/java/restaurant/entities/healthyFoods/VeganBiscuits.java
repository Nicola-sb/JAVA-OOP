package restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food{

    //The VeganBiscuits has a constant value for InitialVeganBiscuitsPortion – 205.

    private static final double INITIAL_VEGAN_PORTION=205;


    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGAN_PORTION, price);
    }
}
