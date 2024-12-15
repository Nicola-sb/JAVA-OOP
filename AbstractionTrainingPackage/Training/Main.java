package AbstractionTrainingPackage.Training;

public class Main {
    public static void main(String[] args) {

        Person person=new Person();
       person.setAge(12);
        System.out.println(person.getAge());
        person.getAllName();
        person.setFirstName("Nikola");
        person.setLastName("Hristov");
        System.out.println(person.getAllName());
        person.setFirstName("Kristina");
        person.setLastName("Ivanova");
        System.out.println(person.getAllName());
//        person.firstName="Nikola";
//        System.out.println(person.firstName);
    }
}
