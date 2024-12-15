package HotelReservation;

public enum Season {

    AUTUMN("Autumn",1),
    SPRING("Spring",2),
    SUMMER("Summer",4),
    WINTER("Winter",3);

    String seasonName;
    double multiplyCoeff;

    Season(String seasonName, double multiplyCoeff) {
        this.seasonName = seasonName;
        this.multiplyCoeff = multiplyCoeff;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public double getMultiplyCoeff() {
        return multiplyCoeff;
    }

    public void setMultiplyCoeff(double multiplyCoeff) {
        this.multiplyCoeff = multiplyCoeff;
    }
}
