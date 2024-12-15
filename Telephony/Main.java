package Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //The input comes from the console. It will hold two lines:
        //•	First line: phone numbers to call (String), separated by spaces.
        //•	Second line: sites to visit (String), separated by spaces

        //•	First, call all numbers in the order of input then browse all sites in order of input.
        //•	The functionality of calling phones is printing on the console the number which are
        //being called in the format: "Calling... {number}".
        //•	The functionality of the browser should print on the console the site in the format:
        //"Browsing: {site}!" (pay attention to the exclamation mark when printing URLs).
        //•	If there is a number in the input of the URLs, print: "Invalid URL!" and continue printing the rest of the URLs.
        //•	If there is a character different from a digit in a number, print: "Invalid number!" and continue to the next number.

        //0882134215 0882134333 08992134215 0558123 3333 1
        //http://softuni.bg http://youtube.com http://www.g00gle.com

        List<String>phoneNumbers= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<String>urls= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Smartphone smartphone=new Smartphone(phoneNumbers,urls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());




    }
}
