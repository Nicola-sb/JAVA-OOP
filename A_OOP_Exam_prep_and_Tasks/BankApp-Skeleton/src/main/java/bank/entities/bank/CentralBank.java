package bank.entities.bank;

public class CentralBank extends BaseBank{

    private static final int CAPACITY_FOR_CENTRALBANK=50;

    public CentralBank(String name) {
        super(name, CAPACITY_FOR_CENTRALBANK);
    }
}
