package SalaryIncreaseAlone;

public class Person {
//    •	firstName: String
//•	lastName: String
//•	age: int
//•	toString() - override
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age,double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary=salary;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
