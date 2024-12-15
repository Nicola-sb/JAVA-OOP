package christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{

//The OpenBooth has a constant value for pricePerPerson – 2.50.

    private static final double PRICE_PER_PERSON_OPEN_BOOTH=2.50;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON_OPEN_BOOTH);
    }
}
