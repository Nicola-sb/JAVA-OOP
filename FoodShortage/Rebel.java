package FoodShortage;

public class Rebel implements Buyer,Birthable,Identifiable,Person {
    private final String name;
    private int age;
    private String group;

    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public void buyFood() {
     food+=5;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
