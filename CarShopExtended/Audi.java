package CarShopExtended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentPerDay;
    private Double pricePerDay;


    public Audi(String model, String color, Integer horsePower, String countryProduced,Integer minRentPerDay,Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentPerDay=minRentPerDay;
        this.pricePerDay=pricePerDay;
    }

    @Override
    public Integer getMinRentPerday() {
        return this.minRentPerDay;
    }

    @Override
    public Double getPricePerDat() {
        return this.pricePerDay;
    }
}
