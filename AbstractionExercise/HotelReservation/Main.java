package AbstractionExercise.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On a single line you will receive all the information about the reservation in the format:
        //"{pricePerDay} {numberOfDays} {season} {discountType}", where:
        String[]inputLine=scanner.nextLine().split(" ");
        double pricePerDay=Double.parseDouble(inputLine[0]);
        int numberOfDays=Integer.parseInt(inputLine[1]);
        Season season=Season.valueOf(inputLine[2].toUpperCase());
        DiscountType discountType=DiscountType.valueOf(inputLine[3].toUpperCase());

        double totalPrice=PriceCalculator.calculates(pricePerDay,numberOfDays,season,discountType);

        System.out.printf("%.2f",totalPrice);
    }
}
