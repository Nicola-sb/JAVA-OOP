package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private ToyRepository toys;
    private Collection<House>houses;

    public ControllerImpl() {
        this.toys=new ToyRepository();
        this.houses=new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        //Creates and adds a House to the houses’ collection. Valid types are: "ShortHouse" and "LongHouse".
        //If the House type is invalid, you have to throw a NullPointerException with the following message
        House house;
        switch (type){
            case "ShortHouse":
                house=new ShortHouse(name);
                break;
            case "LongHouse":
                house=new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        //Creates a toy of the given type and adds it to the ToyRepository. Valid types are:
        //"Ball" and "Mouse". If the toy type is invalid, throw an IllegalArgumentException with a message:
        Toy toy;
        switch (type){
            case "Ball":
                toy=new Ball();
                break;
            case "Mouse":
                toy=new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        //Adds (buys) the desired Toy to the House with the given name. You have to remove the Toy from the ToyRepository if the insert is successful.
        //If there is no such toy, you have to throw an IllegalArgumentException with the following message
        Toy toy=this.toys.findFirst(toyType);//Взимам играчката от списъка с играчките
        if(toy==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND,toyType));
        }
//        switch (toyType){
//            case "Ball":
//                toy=new Ball();
//                break;
//            case "Mouse":
//                toy=new Mouse();
//                break;
//            default:
//                throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND,toyType));
//        }
        House getHouseName = getHouse(houseName);
        getHouseName.buyToy(toy);
        toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    private House getHouse(String houseName) {
        House getHouseName=houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().get();
        return getHouseName;
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        //Creates and adds the desired Cat to the House with the given name. Valid Cat types are: "ShorthairCat", "LonghairCat".
        //Note: The method must first check whether the cat type is valid.
        //If the Cat type is invalid, you have to throw an IllegalArgumentException with the following message:
        House getHouseName=houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().get();
        Cat cat;
        switch (catType){
            case "ShorthairCat":
                cat=new ShorthairCat(catName,catBreed,price);
                break;
            case "LonghairCat":
                cat=new LonghairCat(catName,catBreed,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
//If no errors are thrown, return one of the following strings:
//•	"Unsuitable house." - if the given Cat cannot live in the House.
//•	"Successfully added {catType} to {houseName}." - if the Cat is added successfully in the House.
        boolean catShort=catType.startsWith("Short")&& getHouseName.getClass().getSimpleName().startsWith("Short");
        boolean catLong=catType.startsWith("Long")&& getHouseName.getClass().getSimpleName().startsWith("Long");
        if(catShort || catLong){
            getHouseName.addCat(cat);
        }else{
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        //Feeds all Cat in the House with the given name.
        //Returns a string with information about how many cats were successfully fed, in the following format:
        //•	"Feeding a cat: {fedCount}"
        House house=getHouse(houseName);
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        //Calculates the value of the House with the given name. It is calculated by the sum of all Cat’s and Toy’s prices in the House
        House house=getHouse(houseName);
//        House getHouseName=houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().get();

        double catsSum=house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysSum=house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        double allSum=catsSum+toysSum;

        return String.format(ConstantMessages.VALUE_HOUSE,houseName,allSum);
    }

    @Override
    public String getStatistics() {
        //Returns information about each house. You can use House's getStatistics method to implement the current functionality.
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //..."
        StringBuilder  builder=new StringBuilder();

        for (House house:houses){
           builder.append(house.getStatistics()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
