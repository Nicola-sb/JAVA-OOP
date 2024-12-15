package TrainingPackageInterfaces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Engine engine=new ElectricEngine();
//
//        Car car =new Car(engine);
//        car.startCar();
//        car.stop();


        Mammal personOne=new Person();
        Person personTwo=new Person();

        Person person1=new Person();
//        person.speak();
        makeItSpeak(person1);
        Goat goat=new Goat();
//        goat.speak();
        makeItSpeak(goat);

        Set<Integer>myNumbers=new HashSet<>();
        myNumbers.add(1);
        myNumbers.add(12);
        myNumbers.add(231);
        myNumbers.add(25);
        myNumbers.add(-12);
        myNumbers.add(4);
        myNumbers.forEach(System.out::println);

        myNumbers.stream().sorted().forEach(System.out::println);
        myNumbers=new TreeSet<>(myNumbers);

        Person pesho=new Friend();
        Person nakow=new Enemy();

        pesho=new Enemy();


    }

    public static void makeItSpeak(Mammal mammal){
        mammal.speak();
    }
//    public static void makeItSpeak(Person person){
//        person.speak();
//    }
//    public static void makeItSpeak(Goat goat){
//        goat.speak();
//    }
}
