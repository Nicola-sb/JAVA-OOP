package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Buyer>personMap=new HashMap<>();
        for(int i=1 ;i<=n ;i++){
            String []personPart=scanner.nextLine().split(" ");
            String personName=personPart[0];
            Buyer buyer;
            int personAge=Integer.parseInt(personPart[1]);
            if(personPart.length==4){
                String personId=personPart[2];
                String birthDay=personPart[3];
//                Citizen citizen=new Citizen(personName,personAge,personId,birthDay);
                buyer=new Citizen(personName,personAge,personId,birthDay);
                personMap.put(personName,buyer);
            }else if(personPart.length==3){
                String group=personPart[2];
//                Rebel rebel=new Rebel(personName,personAge,group);
                buyer=new Rebel(personName,personAge,group);
                personMap.put(personName,buyer);
            }
        }

        String nameToFind=scanner.nextLine();
        while (!nameToFind.equals("End")){
            Buyer buyer=personMap.get(nameToFind);
           if(buyer!=null){
               buyer.buyFood();
           }

            nameToFind=scanner.nextLine();
        }

        int allSum=personMap.values().stream().mapToInt(buyer -> buyer.getFood()).sum();
        System.out.println(allSum);
    }
}
