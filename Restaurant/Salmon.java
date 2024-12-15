package Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    private static final double salmonGrams=22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, salmonGrams);

    }
}
