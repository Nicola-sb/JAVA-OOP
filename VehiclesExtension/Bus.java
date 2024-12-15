package VehiclesExtension;

public class Bus extends BaseVechicle{

    private final static double AIR_CONDITON=1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm,double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm,tankCapacity );
    }

//    public void setFuelQuantity(double fuelQuantity) {
//        if(fuelQuantity<0){
//            System.out.println("Fuel must be a positive number");
//        }
//        this.setFuelQuantity(fuelQuantity);
//    }

//    public String driveEmpty(){
//
//    }

}
