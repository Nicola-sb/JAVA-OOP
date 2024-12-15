package AbstractionLab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n=Integer.parseInt(scanner.nextLine());
//
//        for(int row=1 ;row<=n ;row++){
//            print(n,row);
//        }
//
//        for(int row=n-1 ;row>=1 ;row--){
//            print(n,row);
//        }
        int n=Integer.parseInt(scanner.nextLine());

        firstRow(n);

        midleRow(n);

        lastRow(n);


    }

    private static void firstRow(int n) {
        for(int row = 1; row<= n -1 ; row++){
            print(n,row);
        }
    }

    private static void midleRow(int n) {
        for(int star = 1; star<= n; star++){
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void lastRow(int n) {
        for(int row = n -1; row>=1; row--){
            print(n,row);
        }
    }

    private static void print(int n,int row) {
        //Всеки ред-->{брой интервали = n - row}{бр.звезди = row}
        //n==3
        //1 ред -> 2 интервала и 1 звезда
        //2 ред -> 1 интвервал и 2 звезди
        for(int space=1 ;space<=n-row ;space++){
            System.out.print(" ");
        }
        for(int star=1 ;star<=row ;star++){
            System.out.print("* ");
        }
        System.out.println();
    }
}
