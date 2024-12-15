package Restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert{
    //A Cake must have the following members upon initialization:
    //•	double CAKE_GRAMS = 250
    //•	double CAKE_CALORIES = 1000
    //•	BigDecimal CAKE_PRICE = 5
    private final static double cakeGrams=250;
    private final static double cakeCalories=1000;
    private final static BigDecimal cakePrice=BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name,cakePrice, cakeGrams, cakeCalories);
    }
}
