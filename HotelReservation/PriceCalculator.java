package HotelReservation;

public class PriceCalculator {

    public static double calculateSum(double pricePerDay,int numberOfdays,Season season,DiscountType discountType){
        double allSum=pricePerDay*numberOfdays;

        allSum=allSum * season.getMultiplyCoeff();

        allSum=allSum - allSum * (discountType.getPercentageDisocoutn() / 100);

        return allSum;

    }

}
