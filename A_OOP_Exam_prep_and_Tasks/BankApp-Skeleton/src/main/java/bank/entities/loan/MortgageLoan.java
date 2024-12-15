package bank.entities.loan;

public class MortgageLoan extends BaseLoan{

        //The mortgage loan has an interest rate of 3 and an amount of 50 000.
        //Note: The Constructor should take no values upon initialization.
        private static final int INTEREST_RATE_MORTAGE=3;
        private static final double AMOUNT_VALUE_MORTAGE=50000;


    public MortgageLoan() {
        super(INTEREST_RATE_MORTAGE, AMOUNT_VALUE_MORTAGE);
    }
}
