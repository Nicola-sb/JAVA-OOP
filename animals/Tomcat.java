package animals;

public class Tomcat extends Cat {

    private static final String gender="Male";
    public Tomcat(String name, int age) {
        super(name, age, gender);
    }
    public String produceSound(){
        return String.format("MEOW");
    }
}
