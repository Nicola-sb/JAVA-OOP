package SortedByName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String firstName=input[0];
            String lastName=input[1];
            int age=Integer.parseInt(input[2]);
            Person person =new Person(firstName,lastName,age);
            people.add(person);
//            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(people, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));
//        Collections.sort(people,(left,right)-> {
//            int result=left.getFirstName().compareTo(right.getFirstName());
//            if(result==0){
//                return Integer.compare(left.getAge(),right.getAge());
//            }
//                return result;
//
//        });
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}
