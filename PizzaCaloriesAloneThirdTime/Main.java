package PizzaCaloriesAloneThirdTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]pizzaInput=scanner.nextLine().split(" ");
        String piizaName=pizzaInput[1];
        int numberOfToppings=Integer.parseInt(pizzaInput[2]);

//        try{
//            Pizza pizza=new Pizza(piizaName,numberOfToppings);
//        }catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
        String[]doughInput=scanner.nextLine().split(" ");
        String flourType=doughInput[1];
        String bakingTechnique=doughInput[2];
        double weightGrams=Double.parseDouble(doughInput[3]);
//        }
        try{
            Pizza pizza=new Pizza(piizaName,numberOfToppings);
            Dough dough=new Dough(flourType,bakingTechnique,weightGrams);
            pizza.setDough(dough);


            List<Topping>toppingList=new ArrayList<>();
            String command=scanner.nextLine();
            while (!command.equals("END")){
                String[] inputCommand=command.split(" ");
                String toppingType=inputCommand[1];
                double weightGramsTopping=Double.parseDouble(inputCommand[2]);

                    Topping topping=new Topping(toppingType,weightGramsTopping);
                    pizza.addTopping(topping);

                command=scanner.nextLine();
            }

            System.out.printf("%s - %.2f",piizaName,pizza.getOverallCalories());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
