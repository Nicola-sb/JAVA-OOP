package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Read commands till you find the line with the "END" command.
// In case of invalid input (negative money exception message: "Money cannot be negative") or empty name:
// (empty name exception message "Name cannot be empty") break the program with an appropriate message. See the examples below:

        //Peter=11;George=4
        //Bread=10;Milk=2

        Map<String,Person>personMap=new HashMap<>();
        Map<String,Product>productMap=new HashMap<>();

        String []firstInputLine=scanner.nextLine().split(";");
        for (String person:firstInputLine){
            String[] currentPerson=person.split("=");
            String personName=currentPerson[0];
            double moneyPerson=Double.parseDouble(currentPerson[1]);
            try{
                Person person1=new Person(personName,moneyPerson);
                personMap.put(personName,person1);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        String []secondInputLineProduct=scanner.nextLine().split(";");//->["Bread=10","Milk=2"]

        for (String personProduct:secondInputLineProduct){
            String []currentProduct=personProduct.split("=");
            String productName=currentProduct[0];
            double costProduct=Double.parseDouble(currentProduct[1]);

            try{
                Product product1=new Product(productName,costProduct);
                productMap.put(productName,product1);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        List<Product>productToPrint=new ArrayList<>();
        String command=scanner.nextLine();//Peter Bread
        while (!command.equals("END")){
            String personName=command.split(" ")[0];
            String personProduct=command.split(" ")[1];
//            if(personMap.get(personName).buyProduct(productMap.get(personProduct)){
//                System.out.printf("%s bought %s",personMap.get(personName),productMap.get(personProduct));
//            }
            Person buyer=personMap.get(personName);
            Product productToBuy=productMap.get(personProduct);
//            personMap.get(personName).buyProduct(productMap.get(personProduct));
            try{
                buyer.buyProduct(productToBuy);
                productToPrint.add(productToBuy);

                System.out.printf("%s bought %s%n",personName,personProduct);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());;
            }
            command=scanner.nextLine();
        }



        personMap.values().forEach(System.out::println);








    }
}
