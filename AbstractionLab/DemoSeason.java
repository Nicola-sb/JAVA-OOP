package AbstractionLab;

public enum DemoSeason {

    WINTER("Winter",2),
    Basics("Basics",0),
    Fundamentals("Fundamentals",490),
    Advanced("Advanced",490);


    private String name;
    private int temp;





     DemoSeason(String name, int temp) {
        this.name = name;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return String.format("The season is %s and average temeratures is %d",name,temp);
    }
}
