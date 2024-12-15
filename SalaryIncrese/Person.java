package SalaryIncrese;

public class Person {
    //Create a class Person, which should have private fields for:
    //•	firstName: String
    //•	lastName: String
    //•	age: int
    //•	toString() - override
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary=salary;
    }
    public void increaseSalary(double percentegeBonus){
        if(age>30){
            this.salary=salary + (salary * percentegeBonus / 100);
        }else{
            salary = salary + (salary * percentegeBonus / 100 / 2);
        }
    }

    @Override
    public String toString() {
        //Angel Ivanov gets 2640.0 leva
        //Angel Ivanov gets 2640.0 leva
        //Angel Harizanov is 44 years old.
        return String.format("%s %s gets %s leva",firstName,lastName,salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
