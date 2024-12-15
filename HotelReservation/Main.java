package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On a single line you will receive all the information about the reservation in the format:
        //"{pricePerDay} {numberOfDays} {season} {discountType}", where:
        String[]input=scanner.nextLine().split(" ");
        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        Season season=Season.valueOf(input[2].toUpperCase());
        DiscountType discountType=DiscountType.valueOf(input[3].toUpperCase());

        double totalSum=PriceCalculator.calculateSum(pricePerDay,numberOfDays,season,discountType);

        System.out.printf("%.2f",totalSum);
    }
}
