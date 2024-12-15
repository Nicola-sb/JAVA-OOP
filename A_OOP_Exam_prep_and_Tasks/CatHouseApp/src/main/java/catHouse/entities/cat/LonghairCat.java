package catHouse.entities.cat;

public class LonghairCat extends BaseCat{

    public static final int LONGHAIR_KILOGRAMS=9;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, LONGHAIR_KILOGRAMS, price);
    }

    @Override
    public void eating() {
//•	The method increases the cat’s kilograms by 3.
        this.setKilograms(this.getKilograms()+3);
    }
}
