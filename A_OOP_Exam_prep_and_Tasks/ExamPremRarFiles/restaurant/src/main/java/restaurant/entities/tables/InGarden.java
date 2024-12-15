package restaurant.entities.tables;

public class InGarden extends BaseTable{

    //The InGarden table has constant value for pricePerPerson - 4.50
    private static final double PRICE_PER_PERSON_IN_GARDEN=4.50;
    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON_IN_GARDEN);
    }


}
