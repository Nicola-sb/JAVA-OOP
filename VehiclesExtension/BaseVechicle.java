package VehiclesExtension;

import java.text.DecimalFormat;

public  class BaseVechicle {
    protected double fuelQuantity;
    protected double fuelConsumptionPerKm;
    protected double tankCapacity;


    public BaseVechicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    public  String drive(double distance){
        //Car ot Truck? // Може да направим проверка с instance of
        double fuelNeeded=distance * fuelConsumptionPerKm;
        // Проверяваме дали можем да изминем разстоянието
        if(fuelNeeded>this.fuelQuantity){
            //Принтираме,че нямаме достатъчно гориво
            return String.format("%s needs refueling",getClass().getSimpleName());
        }
        //изминаваме го-- намаляваме горивото
        fuelQuantity=fuelQuantity-fuelNeeded;
        //Дистанцията,когато караме колата трябва да я принтираме без водещи нули(трябва да използваме DecimalFormat)
        DecimalFormat decimalFormat=new DecimalFormat("##.##");
        //Трябва да кажем кое (Car/Truck) колко километра е изминало -->
        return String.format("%s travelled %s km",getClass().getSimpleName(),decimalFormat.format(distance));
//        if(this instanceof Car){
//           // return String.format("Car travelled %d km%n",distance); //Връщане на такива стрингове,които се принитрат е лоша практика и е хубаво да хвърляме exception
//            return String.format("%s travelled %d km%n",getClass().getSimpleName(),distance); //Връщане на такива стрингове,които се принитрат е лоша практика и е хубаво да хвърляме exception
//        }else if(this instanceof Truck){
//            return String.format("%s travelled %d km%n",getClass().getSimpleName(),distance);
//        }
    }

    public void refuel(double liters ){
        //Проверяваме дали говоринот НЕ Е по-малко от нула и дали горивото НЕ Е по-голямо от нашия капацитет
        if(liters <=0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        if(fuelQuantity + liters > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
//        if(this instanceof Truck){
//            liters=liters * 0.95;
//        }
     this.fuelQuantity=fuelQuantity+liters;//Когато отида да заредя литрите,които съм напълнил ми ги добавят към резервоара

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity<0){
            System.out.println("Fuel must be a positive number");
        }
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
        return String.format("%s: %.2f",this.getClass().getSimpleName(),fuelQuantity);
    }

}
