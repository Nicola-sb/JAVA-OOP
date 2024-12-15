package PizzaCaloriesAlone;

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
    private String name;
    private Dough dough;
    private List<Topping>toppings;

    public Pizza(String name,int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        toppings=new ArrayList<>();
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() >15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings<0 || numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }
    ////+	addTopping (Topping) : void
    //    //+	getOverallCalories () : double
    public void addTopping(Topping topping){
       toppings.add(topping);
    }
    public double getOverallCalories(){
     return    dough.calculateCalories()+toppings.stream().mapToDouble(element ->element.calculateCalories()).sum();

    }
}
