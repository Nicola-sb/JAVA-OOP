package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.Collection;
import java.util.Map;

public interface Bank {
    String getName();

    void setName(String name);

    Collection<Client> getClients();

    Collection<Loan> getLoans();

    void addClient(Client client);

    void removeClient(Client client);

    void addLoan(Loan loan);

    int sumOfInterestRates();

    String getStatistics();
}
