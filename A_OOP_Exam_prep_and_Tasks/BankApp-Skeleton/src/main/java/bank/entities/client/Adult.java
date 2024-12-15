package bank.entities.client;

public class Adult extends BaseClient{

    //Has initial interest of 4 percent.
    //Can only live in CentralBank!
    //The constructor should take the following values upon initialization:
    //(String name, String ID, double income)
    //Behavior
    //void increase()
    //•	The method increases the client’s interest by 2 percent.
    private static final int INITAL_PERCENT_FOR_ADULT=4;

    public Adult(String name, String ID, double income) {
        super(name, ID, INITAL_PERCENT_FOR_ADULT, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 2);
    }
}
