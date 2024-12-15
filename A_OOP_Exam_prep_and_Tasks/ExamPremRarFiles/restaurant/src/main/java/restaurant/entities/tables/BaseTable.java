package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public  abstract class BaseTable implements Table {
    //•	healthyFood - Collection<HealthyFood> accessible only by the base class
    //•	beverages – Collection<Beverages> accessible only by the base class
    //•	number – int the table number
    //•	size - int the table size
    //o	It can’t be less than zero. In these cases, throw an IllegalArgumentException with the message "Size has to be greater than 0!"
    //•	numberOfPeople - int the counter of people who want a table
    //o	It can’t be less than or equal to 0. In these cases, throw an IllegalArgumentException with the message "Cannot place zero or less people!"
    //•	pricePerPerson - double the price per person for the table
    //•	isReservedTable - boolean returns true if the table is reserved, otherwise false
    //•	allPeople - double calculates the price for all people

    private Collection<HealthyFood>healthyFood;
    private Collection<Beverages>beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;
    //int number, int size, double pricePerPerson

    public BaseTable(int number, int size, double pricePerPerson) {
        this.setNumber(number); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        healthyFood=new ArrayList<>();
        beverages=new ArrayList<>();
//        this.numberOfPeople=numberOfPeople();
//        isReservedTable=false;
//        allPeople=0;
    }

    public void setSize(int size) {
        if(size < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0 ){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        //Reserves the table with the counter of people given.
        //109/150
//        this.setNumberOfPeople(numberOfPeople);
//        isReservedTable=true;
//        this.allPeople=pricePerPerson * numberOfPeople;
        if(numberOfPeople<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople=numberOfPeople;
        isReservedTable=true;

    }

    @Override
    public void orderHealthy(HealthyFood food) {
//Orders the provided healthy food (think of a way to collect all the healthy food which is ordered
        healthyFood.add(food);

    }

    @Override
    public void orderBeverages(Beverages beverages) {
      //Orders the provided beverages (think of a way to collect all the beverages which are ordered)
       this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        //Returns the bill for all orders.
//        double bill=0;

        double billHealthyFood=healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double billBeverages=beverages.stream().mapToDouble(Beverages::getPrice).sum();
//        bill=bill+numberOfPeople;

        return billHealthyFood + billBeverages + (numberOfPeople * pricePerPerson);
    }

    @Override
    public void clear() {
//Removes all the ordered drinks and food and finally frees the table, the table is not reserved, sets the count of people and price to 0
        healthyFood.clear();
        beverages.clear();
        isReservedTable=false;
        numberOfPeople=0;
    }

    @Override
    public String tableInformation() {
        //Return a String with the following format:
        //"Table - {table number}
        //Size - {table size}
        //Type - {table type}
        //All price - {price per person for the current table}"
//        StringBuilder sb=new StringBuilder();
//        sb.append(String.format("Table - %d",number)).append(System.lineSeparator());
//        sb.append(String.format("Size - %d",size)).append(System.lineSeparator());
//        sb.append(String.format("Type - %s",getClass().getSimpleName())).append(System.lineSeparator());
//        sb.append(String.format("All price - %.2f",allPeople));
//
//        return sb.toString().trim();
        //"Table - {table number}
        //Size - {table size}
        //Type - {table type}
        //All price - {price per person for the current table}"
        return String.format("Table - %d%n" +
                "Size - %d%n" +
                "Type - %s%n" +
                "All price - %.2f",number,size,getClass().getSimpleName(),pricePerPerson);
    }

    public Collection<HealthyFood> getHealthyFood() {
        return healthyFood;
    }

    public void setHealthyFood(Collection<HealthyFood> healthyFood) {
        this.healthyFood = healthyFood;
    }

    public Collection<Beverages> getBeverages() {
        return beverages;
    }

    public void setBeverages(Collection<Beverages> beverages) {
        this.beverages = beverages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    public void setReservedTable(boolean reservedTable) {
        isReservedTable = reservedTable;
    }

    public double getAllPeople() {
        return allPeople;
    }

    public void setAllPeople(double allPeople) {
        this.allPeople = allPeople;
    }


}
