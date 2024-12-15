package PizzaCaloriesAlone;

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
    //•	If an invalid flour type or an invalid baking technique is given an exception is thrown with the message "Invalid type of dough.".
    //•	White – 1.5;
    //•	Wholegrain

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }
//•	Crispy – 0.9;
//•	Chewy – 1.1;
//•	Homemade – 1
    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy")&& !bakingTechnique.equals("Chewy")&&!bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight<0 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        //For example, the white dough has a modifier of 1.5, a chewy dough has a modifier of 1.1,
        // which means that a white chewy dough weighing 100 grams will have (2 * 100) * 1.5 * 1.1 = 330.00 total calories.
        return (2*weight)*getModifierFlour()*getBakingTechniqueModifuer();
    }

    private double getModifierFlour(){
        //•	White – 1.5;
        //•	Wholegrain – 1.0;
        switch (flourType){
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }
       return 0;
    }
    private double getBakingTechniqueModifuer(){
        //•	Crispy – 0.9;
        //•	Chewy – 1.1;
        //•	Homemade – 1.0
         switch (bakingTechnique){
             case "Crispy":
                 return 0.9;
             case "Chewy":
                 return 1.1;
             case "Homemade":
                 return 1.0;
         }
         return 0;
    }
}
