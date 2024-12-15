import java.util.*;
import java.util.stream.Collectors;

public class TrainingClass {

    private Map<Integer,Transaction> transactionMap;

    public TrainingClass() {
        this.transactionMap = new HashMap<>();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        //return the transactions with the given status ordered by amount descending.
        // If there are no transactions with the given status, throw IllegalArgumentException.
        //Този метод трябва да ми връща списък с транзакциите,които има този статус
        List<Transaction>transactionList=new ArrayList<>();
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getStatus().equals(status)){
                transactionList.add(transaction);
            }
        }
        if(transactionList.size()==0){
            throw new IllegalArgumentException();
        }

        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionList;
    }
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>transactionList=new ArrayList<>();
        getByTransactionStatus(status).forEach(transactionList::add);
        if(transactionList.size()==0){
            throw new IllegalArgumentException();
        }
        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }
    public Iterable<String> getAllSendersWithTransactionStatus1(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>transactionList=new ArrayList<>();
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getStatus()==status){
                transactionList.add(transaction);
            }
        }
        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }
    public Iterable<String> getAllSendersWithTransactionStatus2(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>transactionList=new ArrayList<>();
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getStatus()==status){
                transactionList.add(transaction);
            }
        }
        if(transactionList.size()==0){
            throw new IllegalArgumentException();
        }
        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }
    public Iterable<String> getAllSendersWithTransactionStatus3(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
       List<Transaction>transactionList=new ArrayList<>();
       getByTransactionStatus(status).forEach(transactionList::add);

       transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
       List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
       return senders;
    }
    public Iterable<String> getAllSendersWithTransactionStatus4(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>transactionList=new ArrayList<>();
        getByTransactionStatus(status).forEach(transactionList::add);

        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }
    //•	getAllSendersWithTransactionStatus(status) – returns all senders which have transactions with the given status ordered by transactions amount
    // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
    public Iterable<String> getAllSendersWithTransactionStatus5(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>transactionList=new ArrayList<>();
        getByTransactionStatus(status).forEach(transactionList::add);

        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String>senders=transactionList.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }
    //•	getByTransactionStatus(status) – return the transactions with the given status ordered by amount descending.
    // If there are no transactions with the given status, throw IllegalArgumentException.


    public Iterable<Transaction> getByTransactionStatus1(TransactionStatus status) {
        //return the transactions with the given status ordered by amount descending.
        // If there are no transactions with the given status, throw IllegalArgumentException.
        //Този метод трябва да ми връща списък с транзакциите,които има този статус
        List<Transaction>transactionList=new ArrayList<>();
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getStatus()==status){
                transactionList.add(transaction);
            }
        }
        if(transactionList.size()==0){
            throw new IllegalArgumentException();
        }
        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        return transactionList;
    }
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
       //returns all transactions ordered by amount descending and by id.
        return transactionMap.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId)).collect(Collectors.toList());
    }

}
