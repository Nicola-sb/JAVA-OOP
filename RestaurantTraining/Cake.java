package RestaurantTraining;

import java.math.BigDecimal;

public class Cake extends Dessert {
    //A Cake must have the following members upon initialization:
    //•	double CAKE_GRAMS = 250
    //•	double CAKE_CALORIES = 1000
    //•	BigDecimal CAKE_PRICE = 5
    private static final double CAKE_GRAMS = 250;
    private static final double CAKE_CALORIES = 1000;
    private static final BigDecimal CAKE_PRICE=BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name, CAKE_PRICE,CAKE_GRAMS,CAKE_CALORIES);
    }

//    public Cake(String name) {
//        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
//    }
}
