package NeedForSpeedAlone;

public class Vehicle {
    public final static double DEFAULT_FUEL_CONSUMPTION=1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
       setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void drive(double kilometers){
        //The drive method should have the functionality to reduce the fuel based on the traveled kilometers and fuel consumption.
        // Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving.
        double consumedFuel=kilometers * getFuelConsumption();
        if(this.fuel>= consumedFuel){
            double leftFuel=getFuel()-consumedFuel;
            this.setFuel(leftFuel);
        }

    }
}
