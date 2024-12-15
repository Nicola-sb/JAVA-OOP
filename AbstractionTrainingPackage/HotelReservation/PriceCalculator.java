package AbstractionTrainingPackage.HotelReservation;

public class PriceCalculator {
    public static double sum(double pricePerDay,int numberOfDays,Season season,DiscountType discountType){
        double price=pricePerDay*numberOfDays;
        price=price*season.getCoeff();

        price=price - price *(discountType.getDiscount() / 100);
        return price;
    }
}
