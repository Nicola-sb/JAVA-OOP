package handball.entities.equipment;

public class BaseEquipment implements Equipment{

    private int protection;
    private double price;

    public BaseEquipment(int protection, double price) {
        this.protection = protection;
        this.price = price;
    }


    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
