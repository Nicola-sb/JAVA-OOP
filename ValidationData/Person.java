package ValidationData;

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

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary< 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }else{
            this.salary = salary;
        }

    }
    public void increaseSalary(double percentege){
        if(this.age>30){
            this.salary=salary + (salary * percentege / 100);
        }else{
            salary = salary + (salary * percentege / 100 / 2);
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
        if(firstName.length()<3){
            throw new IllegalArgumentException("First name should be at least 3 symbols.");
        }else{
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()<3){
            throw new IllegalArgumentException("Last name should be at least 3 symbols.");
        }else{
            this.lastName = firstName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <1){
            throw new IllegalArgumentException("Age cannot be zero or negative number.");
        }else{
            this.age = age;
        }
    }
}
