package RestaurantTraining;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    //A Salmon must have the following members upon initialization:
    //•	double SALMON_GRAMS = 22
    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}
