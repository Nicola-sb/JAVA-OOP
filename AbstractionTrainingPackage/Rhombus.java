package AbstractionTrainingPackage;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        //Всеки ред-->{брой интервали = n - row}{бр.звезди = row}
        //n==3
        //1 ред -> 2 интервала и 1 звезда
        //2 ред -> 1 интвервал и 2 звезди
        for(int row = 1; row<= n  ; row++){
            printRow(n, row);
        }

        for(int row=n-1 ;row>=1 ;row--){
            printRow(n, row);
        }
    }

    private static void downRow(int n, int row) {
        for(int space = 1; space<= n - row; space++){
            System.out.print(" ");
        }
        for(int star = 1; star<= row; star++){
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printRow(int n,int row) {
        //Всеки ред-->{брой интервали = n - row}{бр.звезди = row}
        //n==3
        //1 ред -> 2 интервала и 1 звезда
        //2 ред -> 1 интвервал и 2 звезди
        downRow(n, row);
    }
}
