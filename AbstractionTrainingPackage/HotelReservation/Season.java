package AbstractionTrainingPackage.HotelReservation;

public enum Season {

    WINTER("Winter",3),
    SUMMER("Summer",4),
    SPRING("Spring",2),
    AUTUMN("Autumn",1);
    private String name;
    int coeff;

    Season(String name, int coeff) {
        this.name = name;
        this.coeff = coeff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
}
