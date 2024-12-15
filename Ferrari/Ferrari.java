package Ferrari;

public class Ferrari implements Car{
    String driverName;
    private static final String model="488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
      return  "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        //"{model}/{brakes}/{gas}/{driver's name}"
        return String.format("%s/%s/%s/%s",model,this.brakes(),this.gas(),driverName);
    }
}
