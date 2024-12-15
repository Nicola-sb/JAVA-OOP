package bank.entities.client;

public class Student extends BaseClient{

    //Has initial interests of 2 percent.
    //Can only live in BranchBank!
    //The constructor should take the following values upon initialization:
    //(String name, String ID, double income)
    //Behavior
    //void increase()
    //•	The method increases the client’s interest by 1 percent
    private static final int INITIAL_INTEREST_STUDENT=2;

    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST_STUDENT, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 1);
    }

}
