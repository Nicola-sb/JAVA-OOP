package VehicleAlone;

import VehiclesExtension.BaseVechicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


         String[] vehicleInput=scanner.nextLine().split("\\s+");
         //Vehicle {initial fuel quantity} {liters per km} {tank capacity}
         String vehicleType=vehicleInput[0];
         double initialFuelQuantity=Double.parseDouble(vehicleInput[1]);
         double litersPerKm=Double.parseDouble(vehicleInput[2]);
         double tankCapacity=Double.parseDouble(vehicleInput[3]);

         BaseVechicle baseVechicle=new BaseVechicle(initialFuelQuantity,litersPerKm,tankCapacity);

         Map<String,BaseVechicle>baseVechicleMap=new LinkedHashMap<>();

         baseVechicleMap.put("Car",baseVechicle);
         vehicleInput=scanner.nextLine().split("\\s+");
        double initialFuelQuantityTruck=Double.parseDouble(vehicleInput[1]);
        double litersPerKmTruck=Double.parseDouble(vehicleInput[2]);
        double tankCapacityTrcuk=Double.parseDouble(vehicleInput[3]);

        BaseVechicle baseVechicleTruck=new BaseVechicle(initialFuelQuantityTruck,litersPerKmTruck,tankCapacityTrcuk);

         baseVechicleMap.put("Truck",baseVechicleTruck);
        vehicleInput=scanner.nextLine().split("\\s+");
        double initialFuelQuantityBus=Double.parseDouble(vehicleInput[1]);
        double litersPerKmBus=Double.parseDouble(vehicleInput[2]);
        double tankCapacityBus=Double.parseDouble(vehicleInput[3]);

        BaseVechicle baseVechicleBus=new BaseVechicle(initialFuelQuantityBus,litersPerKmBus,tankCapacityBus);

         baseVechicleMap.put("Bus",baseVechicle);

         int n=Integer.parseInt(scanner.nextLine());
         for(int i=0 ;i<n ;i++){
             String []inputCommands=scanner.nextLine().split("\\s+");
             //o	Drive Car {distance}
             //o	Drive Truck {distance}
             //o	Drive Bus {distance}
             //o	DriveEmpty Bus {distance}
             //o	Refuel Car {liters}
             //o	Refuel Truck {liters}
             //o	Refuel Bus {liters
             String command=inputCommands[0];
             String searchType=inputCommands[1];

             switch (command){
                 case "Drive":
                     double distance=Double.parseDouble(inputCommands[2]);

                     break;
                 case "Refuel":
                     break;
                 case "DriveEmpty":
                     double distanceEmpty=Double.parseDouble(inputCommands[2]);
                     break;
             }





         }








    }
}
