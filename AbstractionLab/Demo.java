package AbstractionLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String autumnSeason="Autumn";
       String winterSeason="Winter";
       String summerSeason="Summer";
       String springSeason="Spring";


       int autumnTemp=16;
       int winterTemp=2;
       int summerTemp=24;
       int springTemp=16;

        System.out.println(DemoSeason.WINTER.toString());
        Arrays.stream(DemoSeason.values()).forEach( e -> System.out.println(e.ordinal()));


        System.out.println(Season.SPRING);

        CounterClass counterClass1=new CounterClass();
        counterClass1.printCounters();
        CounterClass counterClass2=new CounterClass();
        counterClass2.printCounters();

    }
    public void printEnumeration(){
        DemoSeason[] demoSeasons = DemoSeason.values();
    }
}
