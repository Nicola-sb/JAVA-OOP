package VehicleAlone;

public class Car extends Vehicle{

    private final static double FUEL_AIR_CONSUMPTION=0.9;


    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + FUEL_AIR_CONSUMPTION);
    }
}
