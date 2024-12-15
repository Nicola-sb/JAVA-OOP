package NeedForSpeed;

public class SportCar extends Car {
    private static final double defaulConsumption=10;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(defaulConsumption);
    }
}
