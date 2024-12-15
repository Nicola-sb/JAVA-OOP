package AbstractionExercise.HotelReservation;

public enum DiscountType {

    //•	20% for VIP clients - VIP
    //•	10% for clients, visiting for a second time - SecondVisit
    //•	0% if there is no discount - None
    VIP("VIP",20),
    SECONDVISIT("SecondVisit",10),
    NONE("None",0);

    private String name;
    private double percent;

    DiscountType(String name, double discount) {
        this.name = name;
        this.percent = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
