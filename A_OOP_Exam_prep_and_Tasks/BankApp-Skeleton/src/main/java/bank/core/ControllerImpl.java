package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{


    //•	loans - LoanRepository
    //•	banks - Collection<Bank>
    private LoanRepository loanRepository;
    private Map<String ,Bank> banks;

    public ControllerImpl() {
        loanRepository=new LoanRepository();
        banks=new LinkedHashMap<>();
    }

    @Override
    public String addBank(String type, String name) {
        //Creates and adds a Bank to the banks’ collection. Valid types are: "CentralBank" and "BranchBank".
        //If the Bank type is invalid, you have to throw a IllegalArgumentException with the following message:
        //•	"Invalid bank type."
        //If the Bank is added successfully, the method should return the following String:
        //•	"{bankType} is successfully added."
        Bank bank;
        switch (type){
            case "CentralBank":
                bank=new CentralBank(name);
                break;
            case "BranchBank":
                bank=new BranchBank(name);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }
        banks.put(name,bank);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String addLoan(String type) {
        //Creates a loan of the given type and adds it to the LoanRepository.
        // Valid types are: "StudentLoan" and "MortgageLoan". If the loan type is invalid, throw an IllegalArgumentException with a message:
        //•	"Invalid loan type."
        //The method should return the following string if the operation is successful:
        //•	"{loanType} is successfully added."
        Loan loan;
        switch (type){
            case "StudentLoan":
                loan=new StudentLoan();
                break;
            case "MortgageLoan":
                loan=new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }
        loanRepository.addLoan(loan);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        //Adds the returned Loan to the Bank with the given name. You have to remove the Loan from the LoanRepository if the insert is successful.
        //It is important to note that the bank referenced by the bankName parameter will always exist in the BankRepository.
        // Therefore, you can assume that the specified bank is valid and present.
        //If there is no such loan, you have to throw an IllegalArgumentException with the following message:
        //•	"Loan of type {loanType} is missing."
        //If no exceptions are thrown, return the String:
        //•	"{loanType} successfully added to {bankName}."
        Bank currentBank=banks.get(bankName);//Това ми е банката
        Loan loanToFInd=loanRepository.findFirst(loanType);
        if(loanToFInd==null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND,loanType));
        }
        currentBank.getLoans().add(loanToFInd);
        loanRepository.removeLoan(loanToFInd);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,loanType,bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        //Creates and adds the desired Client to the Bank with the given name.
        //Valid Client types are: "Student" and "Adult".
        //Note: The method must first check whether the client type is valid.
        //If the Client type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid client type."
        //If the clientTypeName is not "Adult" for the CentralBank or "Student" for the BranchBank, the client type is considered unsuitable for the Bank.
        //If no errors are thrown, return one of the following strings:
        //•	"Unsuitable bank." - if the given Client cannot be a user of the Bank.
        //For reference: check their description from Task 1.
        //•	"{clientType} successfully added to {bankName}." - if the Client is added successfully in the Bank.
        Client client;
        switch (clientType){
            case "Student":
                client=new Student(clientName,clientID,income);
                break;
            case "Adult":
                client=new Adult(clientName,clientID,income);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }
        Bank currentBankanme=banks.get(bankName);
        currentBankanme.addClient(client);
        boolean isSuitable=clientType.equals("Adult") && getClass().getSimpleName().equals("CentralBank")
                || clientType.equals("Student") && getClass().getSimpleName().equals("Student");

        if(!isSuitable){
            return ConstantMessages.UNSUITABLE_BANK;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,clientType,bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        //Calculates all funds (income from Client and amount from Loan) that have passed through the Bank with the given name.
        // It is calculated from the sum of all Client and Loan prices in the Bank.
        //Return a string in the following format:
        //•	"The funds of bank {bankName} is {funds}."
        //o	The funds should be formatted to the 2nd decimal place!
        Bank currentBank=banks.get(bankName);

        double funfFromClient=currentBank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double amoutFromLoan=currentBank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double allSumFundsAndAmout=funfFromClient+amoutFromLoan;

        return String.format(ConstantMessages.FUNDS_BANK,bankName,allSumFundsAndAmout);
    }

    @Override
    public String getStatistics() {
        //Returns information about each bank. You can use Bank's getStatistics method to implement the current functionality.
        //"Name: {bankName}, Type: {bankType}
        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}
        //Name: {bankName}, Type: {bankType}
        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}
        //..."
        StringBuilder sb=new StringBuilder();
        for (Bank currentBank : banks.values()) {
            sb.append(currentBank.getStatistics());
        }
        return sb.toString().trim();
    }
}
