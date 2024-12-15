package Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    //Coffee and Tea are hot beverages. The Coffee class must have the following additional members:
    //•	double COFFEE_MILLILITERS = 50
    //•	BigDecimal COFFEE_PRICE = 3.50
    //•	caffeine – double
    //•	Getter for caffeine
    private static final double coffeeMilliliters = 50;
    private static final BigDecimal coffeePrice=new BigDecimal(3.50);

    private double caffeine;

    //String name, BigDecimal price, double milliliters

    public Coffee(String name,double caffeine) {
        super(name, coffeePrice, coffeeMilliliters);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
