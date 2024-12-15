package VehicleAlone;

public class Truck extends Vehicle{

    private final static double FUEL_AIR_CONDITIONAL=1.6;
    private final static double FUEL_HOLE=0.95;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + FUEL_AIR_CONDITIONAL);
    }


    @Override
    void refuel(double liters) {
        liters=liters * FUEL_HOLE;
        super.refuel(liters);
    }
}
