package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }
    private void setToppingType(String toppingType) {
           if(!toppingType.equals("Meat") && !toppingType.equals("Veggies")&&!toppingType.equals("Cheese")&&!toppingType.equals("Sauce")){
               String toppingException=String.format("Cannot place %s on top of your pizza.",toppingType);
               throw new IllegalArgumentException(toppingException);
           }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight<1 || weight>50){
            String weightException=String.format("%s weight should be in the range [1..50].",toppingType);
            throw new IllegalArgumentException(weightException);
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        //Трябва да си създаме метод за да си намеря getBakingTechnniqueModifier()
        return (2 * weight) * getToppingModifier();
    }

    private double getToppingModifier() {
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;
        switch (toppingType){
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
        }
        return 0;
    }
}
