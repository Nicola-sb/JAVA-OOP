package PizzaCaloriesAlone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	On the first line is the pizza name and the number of toppings it has in the format:
        //Pizza {pizzaName} {numberOfToppings}
        //Pizza Meatless 2

        //•	On the second line you will get input for the dough in the format:
        //Dough {flourType} {bakingTechnique} {weightInGrams}
        //Dough Wholegrain Crispy 100

        //•	On the next lines, you will receive every topping the pizza has, until an"END" command is given:
        //Topping {toppingType} {weightInGrams
        //Topping Veggies 50
        //Topping Cheese 50
        //END
        String []inputPiiza=scanner.nextLine().split(" ");
        String pizzaName=inputPiiza[1];
        int numberOfToppings=Integer.parseInt(inputPiiza[2]);
        String[]inputDough=scanner.nextLine().split(" ");
        String flourType=inputDough[1];
        String bakingTechnique=inputDough[2];
        double weighGrams=Double.parseDouble(inputDough[3]);
        try{
            Pizza myPizza=new Pizza(pizzaName,numberOfToppings);
            Dough myDough=new Dough(flourType,bakingTechnique,weighGrams);
            myPizza.setDough(myDough);


            String command=scanner.nextLine();
            while (!command.equals("END")){
                String []inputTopping=command.split(" ");
                String toppingType=inputTopping[1];
                double weighGramsTopping=Double.parseDouble(inputTopping[2]);

                Topping myTopping=new Topping(toppingType,weighGramsTopping);
                myPizza.addTopping(myTopping);
                command=scanner.nextLine();
            }
            System.out.printf("%s - %.2f",pizzaName,myPizza.getOverallCalories());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
