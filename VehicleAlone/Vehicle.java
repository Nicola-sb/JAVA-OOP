package VehicleAlone;

import java.text.DecimalFormat;

public abstract class Vehicle {
   protected double fuelQuantity;
   protected double fuelConsumptionPerKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    String drive(double distnace){
        double fuelNeeded=distnace*fuelConsumptionPerKm;

        if(fuelNeeded > fuelQuantity){
          return String.format("%s needs refueling",this.getClass().getSimpleName());// System.out.printf("%s needs refueling%n",this.getClass().getSimpleName());
        }

        fuelQuantity=fuelQuantity-fuelNeeded;
        //"Car/Truck travelled {distance} km"
        DecimalFormat decimalFormat=new DecimalFormat("##.##");
        return String.format("%s travelled %s km",this.getClass().getSimpleName(),decimalFormat.format(distnace));
    }
    void refuel(double liters){
         fuelQuantity=fuelQuantity+liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),getFuelQuantity());
    }
}
