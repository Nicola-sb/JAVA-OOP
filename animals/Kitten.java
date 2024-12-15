package animals;

public class Kitten extends Cat{
    private static final String gender="Female";
    public Kitten(String name, int age) {
        super(name, age, gender);
    }
    public String produceSound(){
        return String.format("Meow");
    }
}
