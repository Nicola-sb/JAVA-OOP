package bank.entities.bank;

public class BranchBank extends BaseBank{

    //Has 25 capacity.
    //The constructor should take the following values upon initialization:
    //(String name
    private static final int CAPACITY_FOR_BRANCHBANK=25;

    public BranchBank(String name) {
        super(name, CAPACITY_FOR_BRANCHBANK);
    }
}
