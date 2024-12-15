package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, BaseVechicle>vehicleMap=new LinkedHashMap<>();

        String[] tokens=scanner.nextLine().split("\\s+");
        BaseVechicle car = getVehicle(tokens);
        vehicleMap.put("Car",car);

        tokens=scanner.nextLine().split("\\s+");
        BaseVechicle truck = getVehicle(tokens);
        vehicleMap.put("Truck",truck);

        tokens=scanner.nextLine().split("\\s+");
        BaseVechicle bus=getVehicle(tokens);
        vehicleMap.put("Bus",bus);

        int n=Integer.parseInt(scanner.nextLine());

        for(int i=0 ;i<n ;i++){
            tokens=scanner.nextLine().split("\\s+");
            String command=tokens[0];
            String vechihleType=tokens[1];

            switch (command){
                case "Drive":
                    double distance=Double.parseDouble(tokens[2]);
                    BaseVechicle vehicle=vehicleMap.get(vechihleType);
                    if(vehicle instanceof Bus ){
                        bus.setFuelConsumptionPerKm(bus.getFuelConsumptionPerKm()+ 1.4);
                        System.out.println(bus.drive(distance));
                        bus.setFuelConsumptionPerKm(bus.getFuelConsumptionPerKm() - 1.4);
                        continue;
                    }
//                    String driveMeesage=vehicleMap.get(vechihleType).drive(distance);
//                    System.out.println(driveMeesage);
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
                case "DriveEmpty":
                    double driveEmptyDistance=Double.parseDouble(tokens[2]);
                    String driveEmtpyMessage=bus.drive(driveEmptyDistance);
                    System.out.println(driveEmtpyMessage);
                    break;
            }
        }

//        Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
        vehicleMap.values().stream().forEach(System.out::println);

    }

    private static BaseVechicle getVehicle(String[] tokens) {
        String vechileType=tokens[0];
        double fuelQuantity=Double.parseDouble(tokens[1]);
        double fuelConsumptionPerKm=Double.parseDouble(tokens[2]);
        double tankCapacity=Double.parseDouble(tokens[3]);

        BaseVechicle vehicle=null;
        switch (vechileType){
            case "Car":
            vehicle=new Car(fuelQuantity,fuelConsumptionPerKm,tankCapacity);
                break;
            case "Truck":
                vehicle=new Truck(fuelQuantity,fuelConsumptionPerKm,tankCapacity);
                break;
            case "Bus":
              vehicle  =new Bus(fuelQuantity,fuelConsumptionPerKm,tankCapacity);
                break;
        }
        return vehicle;
    }

}
