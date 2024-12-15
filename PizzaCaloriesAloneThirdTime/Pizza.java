package PizzaCaloriesAloneThirdTime;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    //-	name: String
    //-	dought:  Dough
    //-	toppings: List<Topping>
    //+ 	Piza (String, int numberOfToppings)
    //-	setToppings(int) : void
    //-	setName(String) : void
    //+	setDough(Dough) : void
    //+	getName(): String
    //+	addTopping (Topping) : void
    //+	getOverallCalories () : double
    private String name;
    private Dough dough;
    private List<Topping>toppings;

    public Pizza(String name,int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty() || name.length()>15|| name.length()<1){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings<0 ||numberOfToppings>10){
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
//  addTopping (Topping) : void
//getOverallCalories () : double
    public void addTopping (Topping topping){
        toppings.add(topping);
    }
    public double getOverallCalories(){
        return  dough.calculateCalories() + toppings.stream().mapToDouble(topping -> topping.calculateCaloriesToppings()).sum();
    }
}
