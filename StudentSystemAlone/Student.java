package StudentSystemAlone;

public class Student {
    private String name;
    private int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        setAge(age);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {

        this.grade = grade;
    }

    @Override
    public String toString() {
        //"{studentName} is {studentAge} years old. {commentary}.", where the commentary is based on the student’s grade.
        return String.format("%s is %d years old. %s",name,age,grade);
    }

}
