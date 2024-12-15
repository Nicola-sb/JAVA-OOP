package ShoppingSpreeAlone;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //In the first two lines, you are given all people and all products.
        // After all, purchases print every person in the order of appearance and all products that he has bought also in order of appearance.
        // If nothing is bought, print:
        //"{Person name} - Nothing bought

        //Peter=11;George=4
        //Bread=10;Milk=2
        Map<String,Person>personDoubleMap=new LinkedHashMap<>();
        Map<String,Product>productDoubleMap=new LinkedHashMap<>();

        String[]inputPerson=scanner.nextLine().split(";");
//        /
        for (String element:inputPerson){
            //Peter=11;George=4
            String name=element.split("=")[0];
            double money=Double.parseDouble(element.split("=")[1]);
            try{
                Person person=new Person(name,money);
                personDoubleMap.put(name,person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;

            }
        }
        String[]inputProducts=scanner.nextLine().split(";");
        for (String element:inputProducts){
            String name=element.split("=")[0];
            double cost=Double.parseDouble(element.split("=")[1]);
            try{
                Product product=new Product(name,cost);
                productDoubleMap.put(name,product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;

            }
        }
        List<Product>productsToPrint=new ArrayList<>();

        String command=scanner.nextLine();
        while (!"END".equals(command)){
            String[]input=command.split(" ");
            //Peter Bread
            String personName=input[0];
            String productName=input[1];

            Person buyer=personDoubleMap.get(personName);
            Product productTobuy=productDoubleMap.get(productName);
            
            try{
                buyer.buyProduct(productTobuy);
//                productsToPrint.add(productTobuy);
                System.out.printf("%s bought %s%n",personName,productName);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            command=scanner.nextLine();
        }

         personDoubleMap.values().forEach(System.out::println);

    }
}
