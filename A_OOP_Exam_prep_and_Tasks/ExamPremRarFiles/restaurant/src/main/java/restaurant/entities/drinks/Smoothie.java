package restaurant.entities.drinks;

public class Smoothie extends BaseBeverage{

//he Smoothie has a constant value for smoothiePrice - 4.50.
    private static final double PRICE_FOR_SMOOTHIE=4.50;


    public Smoothie(String name, int counter, String brand) {
        super(name, counter, PRICE_FOR_SMOOTHIE, brand);
    }
}
