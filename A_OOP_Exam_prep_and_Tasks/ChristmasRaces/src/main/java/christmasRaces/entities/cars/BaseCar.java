package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    protected void setHorsePower(int horsePower){
        //Every type of car has a different range of valid horsepower. If the horsepower is not in the valid range, throw an IllegalArgumentException
        this.checkHorsePower(horsePower);
        this.horsePower=horsePower;
    }
    protected abstract void checkHorsePower(int horsePower);
    //Този абстрактен метод си го викам в сетъра и той ми се грижи за проверката за конските сили

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
//cubic centimeters / horsepower * laps
        return cubicCentimeters / horsePower * laps;
    }

    private void setModel(String model){
        if(model==null || model.trim().length() < 4){
            String exceptionMessage=String.format(ExceptionMessages.INVALID_MODEL,model,4);
            throw  new IllegalArgumentException(exceptionMessage);
        }
        this.model=model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }
}
