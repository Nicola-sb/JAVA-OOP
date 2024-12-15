package AbstractionLab;

public enum Season {

    SUMMER("Summer",24),
    WINTER("Winter",2),
    AUTUMN("Autumn",16),
    SPRING("Spring",16);
    private String name;
    private int temp;

    Season(String name, int temp) {
        this.name = name;
        this.temp = temp;
    }

}
