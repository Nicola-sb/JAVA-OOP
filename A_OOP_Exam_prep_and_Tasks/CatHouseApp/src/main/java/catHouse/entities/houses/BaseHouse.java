package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy>toys;
    private Collection<Cat>cats;



    public BaseHouse(String name, int capacity) {
        this.name=name;
        this.capacity = capacity;
        this.toys=new ArrayList<>();
        this.cats=new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        //Returns the sum of each toy’s softness in the House.
        int sum=0;
        for (Toy toy:toys){
            sum=sum + toy.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
//Adds a Cat in the House if there is a capacity for it.
//If there is not enough capacity to add the Cat in the House, throw an IllegalStateException with the following message:
//•	"Not enough capacity for this cat."
        if(cats.size()>=capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
       this.toys.add(toy);
    }

    @Override
    public void feeding() {
//The feeding() method feeds all cats in the House.
        for (Cat cat:cats){
            cat.eating();
        }

    }

    @Override
    public String getStatistics() {
// Returns a String with information about the House in the format below.
//If the House doesn't have a cat, print "none" instead.
//"{houseName} {houseType}:
//Cats: {catName1} {catName2} {catName3} ... / Cats: none
//Toys: {toysCount} Softness: {sumSoftness}"
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("%s %s:",this.getName(),this.getClass().getSimpleName())).append(System.lineSeparator());
        if(cats.size()==0){
            builder.append("Cats: none").append(System.lineSeparator());
        }else {
            builder.append("Cats: ").append(cats.stream().map(Cat::getName).collect(Collectors.joining(" ")).trim());
            builder.append(System.lineSeparator());
        }
        builder.append(String.format("Toys: %d Softness: %d",toys.size(),sumSoftness()));

        return builder.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.cats.size();
    }

    @Override
    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name=name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
