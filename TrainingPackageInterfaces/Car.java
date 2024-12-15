package TrainingPackageInterfaces;

public class Car {
    public Car(Engine engine) {
        this.engine = engine;
    }

    Engine engine;

    public void startCar(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

}
