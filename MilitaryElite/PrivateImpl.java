package MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private{

    private double salary;


    public PrivateImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.salary=salary;
    }

    @Override
    public double getSalary() {
        return 0;
    }
}
