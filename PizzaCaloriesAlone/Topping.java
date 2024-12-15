package PizzaCaloriesAlone;

public class Topping {
    //-	toppingType: String
    //-	weight: double
    //+ 	Topping (String, double)
    //-	setToppingType (String): void
    //-	setWeight (double): void
    //+	calculateCalories (): double
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }
//•	Meat – 1.2;
//•	Veggies – 0.8;
//•	Cheese – 1.1;
//•	Sauce
    private void setToppingType(String toppingType) {
        if(!toppingType.equals("Meat")&&!toppingType.equals("Veggies")&&!toppingType.equals("Cheese")&&!toppingType.equals("Sauce")){
            String exceptionTopping=String.format("Cannot place %s on top of your pizza.",toppingType);
            throw new IllegalArgumentException(exceptionTopping);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight<0 || weight>50){
            String exceptionWeigh=String.format("%s weight should be in the range [1..50].",toppingType);
            throw new IllegalArgumentException(exceptionWeigh);
        }
        this.weight = weight;
    }

    private double getToppingModifier(){
        switch (toppingType){
            //•	Meat – 1.2;
            //•	Veggies – 0.8;
            //•	Cheese – 1.1;
            //•	Sauce – 0.9
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
    public double calculateCalories(){
        //For example, meat has a modifier of 1.2, which means that
        // meat weighing 50 grams will have (2 * 50) * 1.2 = 120.00 total calories

        return (2 * weight) * getToppingModifier();
    }

}
