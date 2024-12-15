package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;
import java.util.Map;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;
//
//    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
//        this.delicacyRepository=delicacyRepository;
//        this.cocktailRepository=cocktailRepository;
//        this.boothRepository=boothRepository;
//        totalIncome=0;
//    }
//    private final DelicacyRepository<Delicacy> delicacyRepository;
//    private final CocktailRepository<Cocktail> cocktailRepository;
//    private final BoothRepository<Booth> boothRepository;
//    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }

//    @Override
//    public String addDelicacy(String type, String name, double price) {
//        Delicacy delicacy=delicacyRepository.getByName(name);
//        if(delicacy== null){
//            DelicacyType currentType=DelicacyType.valueOf(type);
//            switch (currentType){
//                case Gingerbread:
//                    delicacy=new Gingerbread(name,price);
//                    break;
//                case Stolen:
//                    delicacy=new Stolen(name,price);
//                    break;
//            }
//        }else{
//            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));
//        }
//
//        delicacyRepository.add(delicacy);
//        return String.format(OutputMessages.DELICACY_ADDED, name, type);
//    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        //Creates a delicacy with the correct type. If the delicacy is created successfully, returns:
        //"Added delicacy {delicacy name} - {delicacy type} to the pastry shop!"
        //If a delicacy with the given name already exists in the delicacy repository,
        // throw an IllegalArgumentException with the message "{type} {name} is already in the pastry shop!"
        Delicacy delicacy=delicacyRepository.getByName(name);
        if(delicacy== null){
//            DelicacyType currentType=DelicacyType.valueOf(type);
            switch (type){
                case "Gingerbread":
//                case Gingerbread:
                    delicacy=new Gingerbread(name,price);
                    break;
                case "Stolen":
                    delicacy=new Stolen(name,price);
                    break;
            }
        }else{
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }
//@Override
//public String addDelicacy(String type, String name, double price) {
//    Delicacy delicacy = delicacyRepository.getByName(name);
//    if (delicacy == null) {
//        DelicacyType foodType = DelicacyType.valueOf(type);
//        switch (foodType) {
//            case Gingerbread:
//                delicacy = new Gingerbread(name, price);
//                break;
//            case Stolen:
//                delicacy = new Stolen(name, price);
//                break;
//        }
//    } else {
//        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));
//
//    }
//    delicacyRepository.add(delicacy);
//    return String.format(OutputMessages.DELICACY_ADDED, name, type);
//}
    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //Creates a cocktail with the correct type. If the cocktail is created successful, returns:
        //"Added cocktail {cocktailName} - {cocktailBrand} to the pastry shop!”
        //If a cocktail with the given name already exists in the cocktail repository,
        // throw an IllegalArgumentException with the message "{type} {name} is already in the pastry shop!"
        Cocktail cocktail=cocktailRepository.getByName(name);
        if(cocktail==null){
            switch (type){
                case "MulledWine":
                    cocktail=new MulledWine(name,size,brand);
                    break;
                case "Hibernation":
                    cocktail=new Hibernation(name, size, brand);
                    break;
            }
        }else{
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,type,name));
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED,name,brand);
    }
//@Override
//public String addCocktail(String type, String name, int size, String brand) {
//    Cocktail cocktail = cocktailRepository.getByName(name);
//    if (cocktail == null) {
//        CocktailType cocktailType = CocktailType.valueOf(type);
//
//        switch (cocktailType) {
//            case MulledWine:
//                cocktail = new MulledWine(name, size, brand);
//                break;
//            case Hibernation:
//                cocktail = new Hibernation(name, size, brand);
//                break;
//        }
//    } else {
//        String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, cocktail.getClass().getSimpleName(), cocktail.getName());
//        throw new IllegalArgumentException(message);
//    }
//    cocktailRepository.add(cocktail);
//    return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
//}

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //Creates a booth with the correct type and returns:
        //"Added booth number {boothNumber} in the pastry shop!"
        //If a booth with the given name already exists in the booth repository,
        // throw an IllegalArgumentException with the message "Booth {boothNumber} is already added to the pastry shop!"
        Booth booth=boothRepository.getByNumber(boothNumber);
        if(booth == null){
            switch (type){
                case "OpenBooth":
                    booth=new OpenBooth(boothNumber,capacity);
                    break;
                case "PrivateBooth":
                    booth=new PrivateBooth(boothNumber,capacity);
                    break;
            }
        }else{
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST,boothNumber));
        }
        boothRepository.add(booth);

        return String.format(OutputMessages.BOOTH_ADDED,boothNumber);
    }
//@Override
//public String addBooth(String type, int boothNumber, int capacity) {
//    Booth booth = boothRepository.getByNumber(boothNumber);
//    if (booth == null) {
//        BoothType tableType = BoothType.valueOf(type);
//
//        switch (tableType) {
//            case OpenBooth:
//                booth = new OpenBooth(boothNumber, capacity);
//                break;
//            case PrivateBooth:
//                booth = new PrivateBooth(boothNumber, capacity);
//                break;
//        }
//    } else {
//        String message = String.format(ExceptionMessages.BOOTH_EXIST, boothNumber);
//        throw new IllegalArgumentException(message);
//    }
//    boothRepository.add(booth);
//    return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
//}

    @Override
    public String reserveBooth(int numberOfPeople) {
        //Finds a booth that is not reserved, and its capacity is enough for the number of people provided. If there is no such booth returns:
        //"No available booth for {numberOfPeople} people!"
        //In the other case reserves the booth and return:
        //"Booth {boothNumber} has been reserved for {numberOfPeople} people!"
        for (Booth currentBooth : boothRepository.getAll()) {
            if (!currentBooth.isReserved() && currentBooth.getCapacity() >= numberOfPeople) {
                currentBooth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, currentBooth.getBoothNumber(), numberOfPeople);
            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }
//@Override
//public String reserveBooth(int numberOfPeople) {
//    for (Booth booth : boothRepository.getAll()) {
//        if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
//            booth.reserve(numberOfPeople);
//            return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
//
//        }
//    }
//    return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
//}


    @Override
    public String leaveBooth(int boothNumber) {
        //Finds the booth with the same booth number. Gets the bill for that booth, clears it and adds the sum to the total store income.
        // The bill is not only the orders, but the reservation for the number of people as well. Finally returns:
        //"Booth: {boothNumber}"
        //"Bill: {booth bill:f2}"
        Booth currentBooth=boothRepository.getByNumber(boothNumber);
        double getSum=currentBooth.getBill();
        this.totalIncome=totalIncome+getSum;
        currentBooth.clear();

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(String.format("Booth: %d",boothNumber)).append(System.lineSeparator());
        stringBuilder.append(String.format("Bill: %.2f",getSum)).append(System.lineSeparator());

        return stringBuilder.toString().trim();
    }

    @Override
    public String getIncome() {
        //Returns the total income for the pastry shop for all completed bills.
        //"Income: {income:f2}lv"

        return String.format(OutputMessages.TOTAL_INCOME,totalIncome);
    }
//@Override
//public String leaveBooth(int boothNumber) {
//    Booth booth = boothRepository.getByNumber(boothNumber);
//    double bill = booth.getBill();
//    this.totalIncome += bill;
//    booth.clear();
//    return String.format(OutputMessages.BILL, boothNumber, bill);
//}
//
//    @Override
//    public String getIncome() {
//        return String.format(OutputMessages.TOTAL_INCOME, this.totalIncome);
//    }
}

