package christmasPastryShop.entities.delicacies;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        this.name = name;
    }

    public void setPortion(double portion) {
        if(portion <=0 ){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if(price <=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        //Returns a String with information about each delicacy. The returned String must be in the following format:
        //"{current delicacy name}: {current portion - formatted to the second digit}g - {current price - formatted to the second digit}"
        return String.format("%s: %.2fg - %.2flv",name,portion,price);
        //"%s: %.2fg - %.2flv", this.name, this.portion, this.price
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
