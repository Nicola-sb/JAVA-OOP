package AbstractionExercise.HotelReservation;

public class PriceCalculator {
    //price per day, number of days, the season, and a discount type.
    public static double calculates(double pricePerDay,int days,Season season,DiscountType discountType){
         double price=pricePerDay*days;

         price=price*season.getMultiplyCoeff();

         price=price - price *(discountType.getPercent() / 100);

         return price;
    }
}
