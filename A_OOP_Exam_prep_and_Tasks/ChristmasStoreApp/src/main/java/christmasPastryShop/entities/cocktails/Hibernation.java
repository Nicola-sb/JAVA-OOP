package christmasPastryShop.entities.cocktails;

public class Hibernation extends BaseCocktail{

//The Hibernation has а constant value for hibernationPrice – 4.50.
    private static final double HIBERNATION_PRICE=4.50;
    public Hibernation(String name, int size,String brand) {
        super(name, size, HIBERNATION_PRICE, brand);
    }
}
