package TrainingPackageInterfaces;

public class DieselEngine implements FuelEngine{
    @Override
    public void stop() {
        System.out.println("Start");
    }

    @Override
    public void start() {
        System.out.println("Stop");
    }

    @Override
    public void refuel() {
        System.out.println("I''m refueling");
    }
}
