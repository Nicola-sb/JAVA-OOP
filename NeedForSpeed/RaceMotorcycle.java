package NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{
    private static final double defaulFuelConsumption=8;
    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(defaulFuelConsumption);
    }
}
