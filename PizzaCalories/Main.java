package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pizza Meatless 2
        String []inputPizza=scanner.nextLine().split(" ");
        String []inputDough = scanner.nextLine().split(" ");

        String pizzaName=inputPizza[1];
        int numberOfToppings=Integer.parseInt(inputPizza[2]);

        String flourType=inputDough[1];
        String bakingTechnique=inputDough[2];
        double weight=Double.parseDouble(inputDough[3]);
        try{
            Pizza pizza=new Pizza(pizzaName,numberOfToppings);
            //Dough Wholegrain Crispy 100
            //Dough {flourType} {bakingTechnique} {weightInGrams}
            Dough dough=new Dough(flourType,bakingTechnique,weight);
            pizza.setDough(dough);//сетвам на пицата тестото

            //•	On the next lines, you will receive every topping the pizza has, until an"END" command is given:
            //Topping {toppingType} {weightInGrams
            String command=scanner.nextLine();
            while (!command.equals("END")){
                String toppingType=command.split(" ")[1];
                double weightGrams=Double.parseDouble(command.split(" ")[2]);

                Topping topping=new Topping(toppingType,weightGrams);
                pizza.addTopping(topping);
                command=scanner.nextLine();
            }
            System.out.printf("%s - %.2f",pizzaName,pizza.getOverallCalories());
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
