package TrainingPackageInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {

        Lion lion=new Lion();
        Goat goat=new Goat();
        Koala koala=new Koala();

        List<Animal>animals=new ArrayList<>();
        animals.add(lion);
//        animals.add(goat);
//        animals.add(koala);
//        lion.getFood();
//        goat.getFood();
//        koala.getFood();


        for (Animal animal : animals) {
            System.out.println(animal.getFood());
        }

        for (Animal animal : animals) {
            animal.speak();
        }
    }
}
