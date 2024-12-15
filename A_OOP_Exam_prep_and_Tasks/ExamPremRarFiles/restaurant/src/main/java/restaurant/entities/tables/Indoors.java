package restaurant.entities.tables;

public class Indoors extends BaseTable{

    //The Indoors table has constant value for pricePerPerson - 3.50.

    private static final double PRICE_PER_PERSON_INDOORS=3.50;
    public Indoors(int number, int size) {
        super(number, size, PRICE_PER_PERSON_INDOORS);
    }


}
