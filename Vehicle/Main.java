package Vehicle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Vehicle>vehicleMap=new LinkedHashMap<>();

        String[] tokens=scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(tokens);
        vehicleMap.put("Car",car);

        tokens=scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(tokens);
        vehicleMap.put("Truck",truck);

        int n=Integer.parseInt(scanner.nextLine());

        for(int i=0 ;i<n ;i++){
            tokens=scanner.nextLine().split("\\s+");
            String command=tokens[0];
            String vechihleType=tokens[1];

            switch (command){
                case "Drive":
            //Drive Car 500
                    double distance=Double.parseDouble(tokens[2]);
                    //Вместо да проверявам какъв тип ми е превозното средсто Car/Truck това мога да го оставя директно на Мапа
                    String driveMeesage=vehicleMap.get(vechihleType).drive(distance);
                    System.out.println(driveMeesage);
//                    if(vechihleType.equals("Car")){
//                        System.out.println(car.drive(distance));
//                    }else{
//                        System.out.println(truck.drive(distance));
//                    }
                    break;
                case "Refuel":
                    double liters=Double.parseDouble(tokens[2]);
                    vehicleMap.get(vechihleType).refuel(liters);
//                    if(vechihleType.equals("Car")){
//                        car.refuel(liters);
//                    }else{
//                        truck.refuel(liters);
//                    }
                    break;
            }
        }

//        Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
        vehicleMap.values().stream().forEach(System.out::println);

    }

    private static Vehicle getVehicle(String[] tokens) {
        String vechileType=tokens[0];
        double vechitleQuantity=Double.parseDouble(tokens[1]);
        double vechicleFuelConsumption=Double.parseDouble(tokens[2]);

        Vehicle vehicle=null;
        switch (vechileType){
            case "Car":
               vehicle = new Car(vechitleQuantity,vechicleFuelConsumption);
               break;
            case "Truck":
                vehicle= new Truck(vechitleQuantity,vechicleFuelConsumption);
                break;
        }
        return vehicle;
    }

}
