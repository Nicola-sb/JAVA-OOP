package NeedForSpeed;

public class Car extends Vehicle{
    private final static double defaulFuelConsumption=3;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(defaulFuelConsumption);
    }
}
