package RestaurantTraining;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    //Coffee and Tea are hot beverages. The Coffee class must have the following additional members:
    //•	double COFFEE_MILLILITERS = 50
    //•	BigDecimal COFFEE_PRICE = 3.50
    //•	caffeine – double
    //•	Getter for caffeine
    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine=caffeine;

    }

    public double getCaffeine() {
        return caffeine;
    }
}
