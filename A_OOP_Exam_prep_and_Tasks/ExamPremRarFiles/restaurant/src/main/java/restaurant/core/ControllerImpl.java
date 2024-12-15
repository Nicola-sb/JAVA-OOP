package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood>healthFoodRepository;
    private BeverageRepository<Beverages>beverageRepository;
    private TableRepository<Table>tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository=healthFoodRepository;
        this.beverageRepository=beverageRepository;
        this.tableRepository=tableRepository;
        totalMoney=0;
    }

//    @Override
//    public String addHealthyFood(String type, double price, String name) {
//        //TODO:
//        //Creates food with the correct type. If the food is created successfully add it to the food repository and returns:
//        //"Added {name} to the healthy menu!"
//        //If a healthy food with the given name already exists in the food repository,
//        // throw an IllegalArgumentException with the message "{name} is already in the healthy menu!"
//        HealthyFood currentFood=healthFoodRepository.foodByName(name);
//        if(currentFood==null){
//            HealthyFoodType healthyFoodType=HealthyFoodType.valueOf(type);
//            switch (healthyFoodType){
////DelicacyType foodType = DelicacyType.valueOf(type);
//                case Salad:
//                    currentFood=new Salad(name,price);
//                    break;
//                case VeganBiscuits:
//                    currentFood=new VeganBiscuits(name, price);
//                    break;
//
//            }
//        }else{
//            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST,name));
//        }
//        healthFoodRepository.add(currentFood);
//        return String.format(OutputMessages.FOOD_ADDED,name);
//    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood=type.equals("Salad") ? new Salad(name, price) : new VeganBiscuits(name, price);

        HealthyFood healthyPreviouslyAdded=healthFoodRepository.foodByName(name);
        if(healthyPreviouslyAdded == null){
            healthFoodRepository.add(healthyFood);
            return String.format(OutputMessages.FOOD_ADDED,name);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST,name));

    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages=type.equals("Fresh") ? new Fresh(name, counter, brand) : new Smoothie(name, counter, brand);

        Beverages previouslyAdded=beverageRepository.beverageByName(name,brand);

        if(previouslyAdded == null){
            beverageRepository.add(beverages);
            return String.format(OutputMessages.BEVERAGE_ADDED,type,brand);
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST,name));
    }

    @Override
    public String addTable(String type, int number, int size) {
        Table table=type.equals("Indoors") ? new Indoors(number, size) : new InGarden(number, size);

        Table tableToadd=tableRepository.byNumber(number);
        if(tableToadd == null ){
            tableRepository.add(table);
            return String.format(String.format(OutputMessages.TABLE_ADDED,number));
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED,number));
    }

//    @Override
//    public String addBeverage(String type, int counter, String brand, String name){
//        //Important! Firstly create the corresponding object, if possible, and then check if it exists in the records.
//        //Creates a beverage with the correct type. If the beverage is created successful, returns:
//        //"Added {type} - {brand} to the beverage menu!"
//        //If a beverage with the given name already exists in the beverage repository,
//        // throw an IllegalArgumentException with the message "{name} is already in the beverage menu!"
//        Beverages currentBeverenge=beverageRepository.beverageByName(name,brand);
//        if(currentBeverenge==null){
//            //addBeverage Fresh 5 Orange original
//            //addBeverage Fresh -22 Strawberry herbal
//            //addBeverage Fresh 7 Natural original
//
//            //Added Smoothie - Summer to the beverage menu!
//            //Added Fresh - Orange to the beverage menu!
//            //Counter cannot be less or equal to zero!
//            //Added Fresh - Natural to the beverage menu!
//            BeveragesType beveragesType= BeveragesType.valueOf(type);
//            switch (type){
//                case "Fresh":
//                    currentBeverenge=new Fresh(name, counter, brand);
//                    break;
//                case "Smoothie":
//                    currentBeverenge=new Smoothie(name, counter, brand);
//                    break;
//            }
//        }else{
//            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST,name));
//        }
//        beverageRepository.add(currentBeverenge);
//
//        return String.format(OutputMessages.BEVERAGE_ADDED,type,brand);
//    }

//    @Override
//    public String addTable(String type, int tableNumber, int capacity) {
//        //Creates a table with the correct type and returns:
//        //"Added table number {number} in the healthy restaurant!"
//        //If a table with the given number already exists in the table repository,
//        // throw an IllegalArgumentException with the message "Table {number} is already added to the healthy restaurant!"
//        Table table=tableRepository.byNumber(tableNumber);
//        if(table == null){
//            TableType tableType=TableType.valueOf(type);
//            switch (tableType){
//                case Indoors:
//                    table=new Indoors(tableNumber,capacity);
//                    break;
//                case InGarden:
//                    table=new InGarden(tableNumber,capacity);
//                    break;
//            }
//        }else{
//            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED,tableNumber));
//        }
//        tableRepository.add(table);
//        return String.format(String.format(OutputMessages.TABLE_ADDED,tableNumber));
//    }

    @Override
    public String reserve(int numberOfPeople) {
        //Finds a table which is not reserved, and its size is enough for the number of people provided. If there is no such table returns:
        //"There is no such table for {numberOfPeople} people."
        //In the other case reserves the table and returns:
        //"Table {number} has been reserved for {numberOfPeople} people."
        for (Table currentTable : tableRepository.getAllEntities()) {
            if(!currentTable.isReservedTable() && currentTable.getSize() >= numberOfPeople){
                currentTable.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED,currentTable.getTableNumber(),numberOfPeople);
            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE,numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //Finds the table with that number and the food with that name on the menu.
        // You first check if the table exists. If there are no such table returns:
        //"Could not find table {tableNumber}."
        //If there are no such food returns:
        //"No {healthyFoodName} in the healthy menu."
        //In other cases orders the food for that table and returns:
        //"{healthyFoodName} ordered from table {tableNumber}."
        Table currentTable=tableRepository.byNumber(tableNumber);
        HealthyFood currentFood=healthFoodRepository.foodByName(healthyFoodName);
        if(currentTable==null){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER,tableNumber);
        }
        if(currentFood == null){
            return String.format(OutputMessages.NONE_EXISTENT_FOOD,healthyFoodName);
        }
        currentTable.orderHealthy(currentFood);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL,healthyFoodName,tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //Finds the table with that number and find the beverage with that name and brand.
        // You first check if the table exists. If there is no such table, it returns:
        //"Could not find table {tableNumber}."
        //If there isn’t such beverage, it returns:
        //"No {name} - {brand} in the beverage menu."
        //In another case, it orders the beverage for that table and returns:
        //"{name} ordered from table {tableNumber}."
        Table currentTable=tableRepository.byNumber(tableNumber);
        Beverages currentBeverages=beverageRepository.beverageByName(name,brand);
        if(currentTable == null ){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER,tableNumber);
        }
        if(currentBeverages == null){
             return String.format(OutputMessages.NON_EXISTENT_DRINK,name,brand);
        }
        currentTable.orderBeverages(currentBeverages);

        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL,name,tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        //Finds the table with the same table number. Gets the bill for that table and clears it. Finally returns:
        //"Table: {tableNumber} with bill: {table bill formatted to the second digit}."
        Table currentTable=tableRepository.byNumber(tableNumber);
        double tableBill=currentTable.bill();
        totalMoney=totalMoney+currentTable.bill();
        currentTable.bill();
        currentTable.clear();
        return String.format(OutputMessages.BILL,tableNumber,tableBill);
    }


    @Override
    public String totalMoney() {
        //Returns the money earned for the restaurant for all completed bills.
        //"Total money for the restaurant: {money formatted to the second digit}lv."
//        double allSum=0;
//        for (Table currentTable : tableRepository.getAllEntities()) {
//            totalMoney=totalMoney+currentTable.bill();
//            allSum=allSum+currentTable.bill();
//        }
        return String.format(OutputMessages.TOTAL_MONEY,totalMoney);
    }
}
