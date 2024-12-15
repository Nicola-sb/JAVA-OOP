package MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName,Corps corps) {
        super(id, firstName, lastName);
        this.corps=corps;
    }
}
