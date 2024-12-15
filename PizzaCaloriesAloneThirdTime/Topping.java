package PizzaCaloriesAloneThirdTime;

public class Topping {
    //toppingType: String
    //weight: double
    //Topping (String, double)
    //setToppingType (String): void
    //setWeight (double): void
    //calculateCalories (): double
    private String toppingType;
    private  double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //meat, veggies, cheese, or sauce
        if(!toppingType.equals("Meat")&& !toppingType.equals("Veggies")&&!toppingType.equals("Cheese")&&!toppingType.equals("Sauce")){
            String exceptionMessage=String.format("Cannot place %s on top of your pizza.",toppingType);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight<1 || weight>50){
         String exceptionWeigh =   String.format("%s weight should be in the range [1..50].",toppingType);
         throw new IllegalArgumentException(exceptionWeigh);
        }
        this.weight = weight;
    }

    public double getToppingModifier(){
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
    public double calculateCaloriesToppings (){
        return (2*weight) * getToppingModifier();
    }
}
