package PizzaCalories;

public class Dough {
    //-	flourType: String
    //-	bakingTechnique: String
    //-	weight: double
    //+ 	Dought (String, String, double)
    //-	setWeight(double): void
    //-	setFlourType(String): void
    //-	setBakingTechnique(String): void
    //+	calculateCalories (): double
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
       setFlourType(flourType);
       setBakingTechnique(bakingTechnique);
       setWeight(weight);
    }
    //•	White – 1.5;
    //•	Wholegrain – 1.0;

    //•	Crispy – 0.9;
    //•	Chewy – 1.1;
    //•	Homemade – 1.0;
//•	If an invalid flour type or an invalid baking technique is given an exception is thrown with the message "Invalid type of dough.".
    private void setFlourType(String flourType) {
        if(!"White".equals(flourType)&& !"Wholegrain".equals(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!"Crispy".equals(bakingTechnique) && !"Chewy".equals(bakingTechnique)&&!"Homemade".equals(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }
//•	If dough weight is outside of the range [1..200] throw an exception with the message "Dough weight should be in the range [1..200]."
    private void setWeight(double weight) {
        if(weight<1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        //Трябва да си създаме метод за да си намеря getBakingTechnniqueModifier()
        return (2 * weight) * getBakingTechnniqueModifier() * getFlourTypeModifier();//Така смятаме калориите на нашето тесто
    }

    private double getBakingTechnniqueModifier(){
        //В зависимост от това как сме направили(technique) тестото ще имам различни modifier
        switch (bakingTechnique){
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1;
        }
        return 0;
    }
    private double getFlourTypeModifier(){

        switch (flourType){
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }
        return 0;
    }
}
