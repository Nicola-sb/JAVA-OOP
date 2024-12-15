package Vehicle;

public class Car extends BaseVechicle {

    private static final double ADDITIONAL_AC_CONSUMPTION=0.9;


    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + ADDITIONAL_AC_CONSUMPTION);
        //Има няколко варианта как да си добавя     private static final double ADDITIONAL_AC_CONSUMPTION=0.9 към разхода на колата

        //1.   this.fuelConsumptionPerKm=this.fuelConsumptionPerKm+ADDITIONAL_AC_CONSUMPTION;
        //2.   super.setFuelConsumptionPerKm(super.getFuelConsumptionPerKm()+ADDITIONAL_AC_CONSUMPTION); --> С използване на гетърите и сетърите-> по този начин
        //във BaseVechile fuelQuantity и fuelConsumptionPerKm могат да си останат private (Иначе по пъривя 1 начин трябва да бъдат protected
        //3. Директно да си добавим ADDITIONAL_AC_CONSUMPTION в суперКонструктора --> super(fuelQuantity, fuelConsumptionPerKm + ADDITIONAL_AC_CONSUMPTION);

        //При 1 трябва да си направим полетата protected
        //При 2 използваме си сетърите и гетърите от super
        //При 3 директно при суперКонструктора си добавяме допълнителния разход 0.9
    }
}
