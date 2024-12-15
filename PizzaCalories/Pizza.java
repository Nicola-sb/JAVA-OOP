package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name,int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length()>15||name.length()<1){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public double getOverallCalories(){
        //Взимаме на тестото калориии и трябва да вземем на всеки един от на топингите калориите
        //Взимам си toppings пускам си стрийм,мапвам към Double и след това
        //Взимам си всичките топинги и ги мапвам към техните калории и накрая му искам сумата(.sum)
        return dough.calculateCalories() + toppings.stream().mapToDouble( topping -> topping.calculateCalories()).sum();
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings< 0 || numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }
}
