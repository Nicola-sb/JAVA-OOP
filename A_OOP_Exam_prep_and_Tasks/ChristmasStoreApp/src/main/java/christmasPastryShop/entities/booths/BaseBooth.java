package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    //•	delicacyOrders – Collection<Delicacy>
    //•	cocktailOrders – Collection<Cocktail>
    //•	boothNumber – int the booth number
    //•	capacity – int the booth capacity.
    //o	 It can’t be less than zero. In these cases, throw an IllegalArgumentException with the message "Capacity has to be greater than 0!"
    //•	numberOfPeople – int the count of people who want a booth.
    //o	 Cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    //•	pricePerPerson – double the price per person for the booth.
    //•	isReserved – boolean returns true if the booth is reserved, otherwise false.
    //•	price – double calculates the price for all people.
//    private Collection<Delicacy>delicacyOrders;
//    private Collection<Cocktail>cocktailOrders;
//    private int boothNumber;
//    private int capacity;
//    private int numberOfPeople;
//    private double pricePerPerson;
//    private boolean isReserved;
//    private double price;
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
//        delicacyOrders=new ArrayList<>();
//        cocktailOrders=new ArrayList<>();
//        this.boothNumber = boothNumber;
//        this.setCapacity(capacity);
//        this.setNumberOfPeople(numberOfPeople);
//        this.pricePerPerson = pricePerPerson;
//        isReserved=false;
//        price=0;
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;

    }

    public void setCapacity(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0 ){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        //Reserve the booth with the count of people given and calculate the price of the booth.
        //Резервирайте щанда с дадения брой хора и изчислете цената на щанда.
        //Трябва да променя isReserved нa true за booth;
        //Трябва да изчисля цената на щанда

        //        this.setNumberOfPeople(numberOfPeople);
        //        isReserved = true;
        //        this.price = this.pricePerPerson * numberOfPeople;
        this.setNumberOfPeople(numberOfPeople);
        isReserved=true;
        this.price=this.pricePerPerson * numberOfPeople;
    }

    public Collection<Delicacy> getDelicacyOrders() {
        return delicacyOrders;
    }

    public void setDelicacyOrders(Collection<Delicacy> delicacyOrders) {
        this.delicacyOrders = delicacyOrders;
    }

    public Collection<Cocktail> getCocktailOrders() {
        return cocktailOrders;
    }

    public void setCocktailOrders(Collection<Cocktail> cocktailOrders) {
        this.cocktailOrders = cocktailOrders;
    }


    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
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
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getBill() {
        //Returns the bill for the booth, all of the ordered cocktails and delicacies
        //Връща сметката за сепарето, всички поръчани коктейли и деликатеси
        double sumCoctails=0;
        for (Cocktail currentCoctail : cocktailOrders) {
            sumCoctails=sumCoctails + currentCoctail.getPrice();
        }
        double sumDelicacies=0;
        for (Delicacy currentDeliciase : delicacyOrders) {
            sumDelicacies=sumDelicacies+currentDeliciase.getPrice();
        }
        double allSum=sumCoctails+sumDelicacies;

        allSum=allSum+getPrice();

        return allSum;
    }

    @Override
    public void clear() {
        //Removes all the ordered cocktails and delicacies and finally frees the booth, sets the count of people and price to 0.
        //Премахва всички поръчани коктейли и деликатеси и накрая освобождава сепарето, задава броя на хората и цената на 0.
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.price = 0;
    }
}
