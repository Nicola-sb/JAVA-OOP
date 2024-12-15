package FirstAndReserveTeamAlone;

public class Person {
//    •	firstName: String
//•	lastName: String
//•	age: int
//•	toString() - override
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonus) {
        //People younger than 30 get a half bonus
        if(age < 30){
            salary=salary + (salary*bonus / 200);
            // salary = salary + (salary * bonus / 100 / 2);
//            /
        }else{
            salary=salary  + (salary * bonus / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",firstName,lastName,salary);
    }
    //•	Names must be at least 3 symbols
    //•	Age must not be zero or negative
    //•	Salary can't be less than 460.0
    //Print proper message to end-user (look at an example for messages).
    //Don't use System.out.println() in Person class.

    public void setFirstName(String firstName) {
        if(firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }else{
            this.firstName=firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }else{
            this.lastName = lastName;
        }
    }

    public void setAge(int age) {
        if(age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }else{
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        if(salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }
}
