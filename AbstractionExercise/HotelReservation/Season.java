package AbstractionExercise.HotelReservation;

public enum Season {

    //•	1 during Autumn
    //•	2 during Spring
    //•	3 during Winter
    //•	4 during Summer
    AUTUMN("Autumn",1),
    SPRING("Spring",2),
    WINTER("Winter",3),
    SUMMER("Summer",4);
    private String name;
    private int multiplyCoeff;

    Season(String name, int multiplyCoeff) {
        this.name = name;
        this.multiplyCoeff = multiplyCoeff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplyCoeff() {
        return multiplyCoeff;
    }

    public void setMultiplyCoeff(int multiplyCoeff) {
        this.multiplyCoeff = multiplyCoeff;
    }
}
