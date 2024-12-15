package TrainingPackageInterfaces;

public class ElectricEngine implements Engine{
    @Override
    public void stop() {
        System.out.println("Starting electring engine");
    }

    @Override
    public void start() {
        System.out.println("Stopping electring engine");
    }
}
