package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    //initial kilograms of 7
    public static final int INITIAL_KILOGRAMS=7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
//•	The method increases the cat’s kilograms by 1.
        this.setKilograms(this.getKilograms() + 1);
    }
}
