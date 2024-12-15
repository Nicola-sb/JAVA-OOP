package AbstractionTrainingPackage.Training;

public class Person {
    private int age;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Person(int age){
        this.age=age;
    }
    public Person(int age,String firstName){
        this.age=age;
        this.firstName=firstName;
    }
    public Person(int age,String firstName,String lastName){
        this(age,firstName);
        this.lastName=lastName;
    }
    public Person(){

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAllName(){
        return this.getFirstName()+" "+ this.getLastName();
    }
}
