package HotelReservation;

public enum DiscountType {



    VIP("Vip",20),
    SECONDVISIT("SecondVisit",10),
    NONE("None",0);

    String discountType;
    double percentageDisocoutn;

    DiscountType(String discountType, double percentageDisocoutn) {
        this.discountType = discountType;
        this.percentageDisocoutn = percentageDisocoutn;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getPercentageDisocoutn() {
        return percentageDisocoutn;
    }

    public void setPercentageDisocoutn(double percentageDisocoutn) {
        this.percentageDisocoutn = percentageDisocoutn;
    }
}
