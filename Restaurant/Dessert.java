package Restaurant;

import java.math.BigDecimal;

public class Dessert extends Food{
    //Dessert must accept one more parameter in its constructor: double calories.
    //•	calories – double
    //•	Getter for calories
    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
//        this.calories = calories;
        setCalories(calories);
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
