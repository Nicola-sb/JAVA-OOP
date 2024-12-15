package christmasPastryShop.entities.cocktails;

public class MulledWine extends BaseCocktail{

//The MulledWine has а constant value for mulledWinePrice – 3.50.

    private static final double MULLED_WINE_PRICE=3.50;

    public MulledWine(String name, int size,String brand) {
        super(name, size, MULLED_WINE_PRICE, brand);
    }
}
