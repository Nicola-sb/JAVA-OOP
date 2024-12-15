package RandomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int g=Integer.parseInt(scanner.nextLine());
//        int n=Integer.parseInt(scanner.nextLine());

        RandomArrayList randomArrayList=new RandomArrayList();
        randomArrayList.add(4);
        randomArrayList.add(43);


        System.out.println(randomArrayList.getRandomElement());




    }
}
