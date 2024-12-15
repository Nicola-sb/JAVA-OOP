package bank.entities.loan;

public class StudentLoan extends BaseLoan {

    //The student loan has an interest rate of 1 and an amount of 10 000.
    //Note: The Constructor should take no values upon initialization.
    private static final int INTEREST_RATE_STUDENT=1;
    private static final double AMOUNT_VALUE_STUDENT=10000;

    public StudentLoan() {
        super(INTEREST_RATE_STUDENT, AMOUNT_VALUE_STUDENT);
    }
}
