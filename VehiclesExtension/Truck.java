package VehiclesExtension;

public class Truck extends BaseVechicle {

    private final static double ADDITIONAL_AC_CONSUMPTION=1.6;
    private final static double RECFUEL_PERCENTAGE=0.95;
    public Truck(double fuelQuantity, double fuelConsumptionPerKm,double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
        super.setFuelConsumptionPerKm(super.getFuelConsumptionPerKm() + ADDITIONAL_AC_CONSUMPTION);
    }


    @Override
    public void refuel(double liters) {
        liters=liters * RECFUEL_PERCENTAGE;//1во намаляваме литрите с 5 %
//        this.fuelQuantity=fuelQuantity+liters; // Или --> Ако полетата в BaseVichicle са ни private -->
        super.refuel(liters);//и след това ги подаваме на refule,което идва от super(което просто добавя литрите към горивото,което имаме)
    }
}
