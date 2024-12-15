package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name== null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender==null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
//        return String.format("%s%n%s %d %s%n%s",getClass().getSimpleName(),name,age,gender,produceSound());
        StringBuilder builder=new StringBuilder();

        builder.append(getClass().getSimpleName()).append(System.lineSeparator());
        builder.append(name).append(" ").append(age).append(" ").append(gender).append(System.lineSeparator());
        builder.append(produceSound());
        return builder.toString();
    }

    public String produceSound(){
        return "";
    }

}
