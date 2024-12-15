package AbstractionTrainingPackage.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //"{pricePerDay} {numberOfDays} {season} {discountType
        String[]input=scanner.nextLine().split(" ");
        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        Season season=Season.valueOf(input[2].toUpperCase());
        DiscountType discountType=DiscountType.valueOf(input[3].toUpperCase());

        double totalSum=PriceCalculator.sum(pricePerDay,numberOfDays,season,discountType);

        System.out.printf("%.2f",totalSum);
    }
}
