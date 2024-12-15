package restaurant.entities.drinks;

public class Fresh extends BaseBeverage{

    private static final double PRICE_FOR_FRESH=3.50;



    public Fresh(String name, int counter, String brand) {
        super(name, counter, PRICE_FOR_FRESH, brand);
    }
}
