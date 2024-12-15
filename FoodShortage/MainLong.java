package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainLong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //when a Rebel buys food his food increases by 5, when a Citizen buys food his food increases by 10

        int n=Integer.parseInt(scanner.nextLine());

        List<Person>buyerList=new ArrayList<>();

        List<Rebel>rebelList=new ArrayList<>();
        List<Citizen>citizenList=new ArrayList<>();

        for(int i=1 ;i<=n ;i++){
            //"{name} {age} {id} {birthdate}" for a Citizen or
            //"{name} {age}{group}" for a Rebel.
            //Peter 25 8904041303 04/04/1989
            //Stan 27 WildMonkeys
            //Peter
            //George
            //Peter
            String[]inputData=scanner.nextLine().split(" ");
            if(inputData.length==4){
                String citizenName=inputData[0];
                int citizenAge=Integer.parseInt(inputData[1]);
                String citizenId=inputData[2];
                String citizenBirthdate=inputData[3];
                Citizen citizen=new Citizen(citizenName,citizenAge,citizenId,citizenBirthdate);
                citizenList.add(citizen);
                buyerList.add(citizen);
            }else if(inputData.length==3){
                String rebelName=inputData[0];
                int rebelAge=Integer.parseInt(inputData[1]);
                String rebelGroup=inputData[2];
                Rebel rebel=new Rebel(rebelName,rebelAge,rebelGroup);
                buyerList.add(rebel);
                rebelList.add(rebel);
            }
        }
       int totalFood=0;
        String inputNameBoughtFood=scanner.nextLine();
        while (!inputNameBoughtFood.equals("End")){

            for (Citizen citizen : citizenList) {
                if(citizen.getName().equals(inputNameBoughtFood)){
                    totalFood=totalFood+10;
                }
            }

            for (Rebel rebel : rebelList) {
                if(rebel.getName().equals(inputNameBoughtFood)){
                    totalFood=totalFood+5;
                }
            }

            inputNameBoughtFood=scanner.nextLine();
        }
        System.out.println(totalFood);


    }
}
