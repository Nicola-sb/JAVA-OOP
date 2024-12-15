package NeedForSpeed;

public class Vehicle {
    //Create a base class Vehicle. It should contain the following members:
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
    //•	fuelConsumption –double
    //•	fuel – double
    //•	horsePower – int
    //•	Getters and Setters for the fields
    //•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
    public final static double defautFuelConsmption = 1.25;
    private double fuelConsumption;//Литри разход за 1 км

    private double fuel;//налични литри гориво

    private int horsePower;//конски сили

    public Vehicle(double fuel, int horsePower) {
        this.fuelConsumption=defautFuelConsmption;
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    //•	void drive(double kilometers)
    //o	The drive method should have the functionality to reduce the fuel based on the traveled kilometers and fuel consumption.
    // Keep in mind that you can drive the vehicle only if you have enough fuel to finish the driving
    public void drive(double kilometeres){
         //1.Колко гориво ще изгорим когато минем kilometres
        double consumedFuel=kilometeres * getFuelConsumption();
        //2.Проверка дали горивото,което имам ще ми стигне
        if(this.fuel>=consumedFuel){
            //Пътувам kilometres
            double leftFuel=this.getFuel()-consumedFuel;
            this.setFuel(leftFuel);
        }
    }
}
