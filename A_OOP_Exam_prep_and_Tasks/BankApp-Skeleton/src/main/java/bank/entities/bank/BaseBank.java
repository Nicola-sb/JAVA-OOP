package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank {

    private String name;
    private int capacity;
    private Collection<Loan>loans;
    private Collection<Client>clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        loans=new ArrayList<>();
        clients=new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public void setLoans(Collection<Loan> loans) {
        this.loans = loans;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int sumOfInterestRates() {
        //Returns the sum of the interest rates of each loan in the Bank.
//        int sum=0;
//        for (Loan loan : loans) {
//            sum = sum + loan.getInterestRate();
//        }
//        return sum;
        return loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public void addClient(Client client) {
        //Adds a Client in the Bank if there is a capacity for it.
        //If there is not enough capacity to add the Client to the Bank, throw an IllegalStateException with the following message:
        //•	"Not enough capacity for this client."
        if(capacity < this.getClients().size()){
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.clients.add(client);

    }

    @Override
    public void removeClient(Client client) {
       this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public String getStatistics() {
        //Returns a String with information about the Bank in the format below.
        //"Name: {bankName}, Type: {bankType}
        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}"
        //Note: I remind you that there are two bank types – CentralBank and BranchBank.
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Name: %s, Type: %s",name,this.getClass().getSimpleName())).append(System.lineSeparator());
        if(this.clients.isEmpty()){
            sb.append("Clients: none");
        }else{
            //Collection<MyObjectType> myCollection = ...;
            //List<MyObjectType> list = new ArrayList<MyObjectType>(myCollection);
//            Collection<Client>myCollection=clients;
            List<Client>clientsList=new ArrayList<>(clients);

            List<String>clienttName=new ArrayList<>();
            for (Client client : clientsList) {
                clienttName.add(client.getName());
            }
            sb.append(String.format("Clients: %s",String.join(", ",clienttName))).append(System.lineSeparator());
        }
        sb.append(String.format("Loans: %d, Sum of interest rates: %d",loans.size(),sumOfInterestRates()));
        return sb.toString();
    }
}
