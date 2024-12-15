import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    //Chainblock --> database with transaction

    private Map<Integer,Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public int getCount() {
      return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
         //Трябва да си взимаме transaction по id и да я добавяме в списъка САМО АКО Я НЯМА
        int id=transaction.getId();
        if(!transactionMap.containsKey(id)){
            transactionMap.put(id,transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
      //Имаме 2 варианта :  1.Да имаме транзакция с даденото id     2.Да нямаме транзакция с даденото id
        if(!transactionMap.containsKey(id)){
            throw new IllegalArgumentException();
        }
        //да имаме транзакция с даденото id
        Transaction transactionForChange=transactionMap.get(id);
        transactionForChange.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if(!transactionMap.containsKey(id)){
            throw new IllegalArgumentException();
        }
          this.transactionMap.remove(id);
    }
//•	getById(id) – return the transaction with the given id. If such transaction doesn't exist, throw IllegalArgumentException
    public Transaction getById(int id) {
        if(!transactionMap.containsKey(id)){
            throw new IllegalArgumentException();
        }
        return transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        //return the transactions with the given status ordered by amount descending.
        // If there are no transactions with the given status, throw IllegalArgumentException.
        //Този метод трябва да ми връща списък с транзакциите,които има този статус
        List<Transaction>filteredTransaction=new ArrayList<>();//транзакции с дадения статус
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getStatus()==status){
                filteredTransaction.add(transaction);
            }
        }
        //Ако нямаме транзакции с дадения статус
        if(filteredTransaction.size()==0){
            throw new IllegalArgumentException();
        }
        //Ако имаме транзакции с дадения статус
        //Ако имам транзакции трябва да ги сортирам по transaction amount i sled towa descening
        filteredTransaction.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return filteredTransaction;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        // returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        List<Transaction>filteredTransaction=new ArrayList<>();
        getByTransactionStatus(status).forEach(filteredTransaction::add);
        if(filteredTransaction.size()==0){
            throw new IllegalArgumentException();
        }
        //сортираме по amount descending
        filteredTransaction.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        //взимаме подателите(from)
        List<String>senders=filteredTransaction.stream().map(Transaction::getFrom).collect(Collectors.toList());
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionMap.values().stream().
                sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId)).collect(Collectors.toList());

    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        //•	getBySenderOrderedByAmountDescending(sender) – search for all transactions with a specific sender and return them ordered by amount descending.
        // If there are no such transactions throw IllegalArgumentException.
       List<Transaction>transactionList=new ArrayList<>();
       for (Transaction transaction:transactionMap.values()){
           if(transaction.getFrom().equals(sender)){
               transactionList.add(transaction);
           }
       }
       if(transactionList.size()==0){
           throw new IllegalArgumentException();
       }
       transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        return transactionList;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        //returns all transactions with particular receiver ordered by amount descending, then by id ascending.
        //If there are no such transactions throw IllegalArgumentException
        List<Transaction>transactionList=new ArrayList<>();
        for (Transaction transaction:transactionMap.values()){
            if(transaction.getTo().equals(receiver)){
                transactionList.add(transaction);
            }
        }
        transactionList.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()
        .thenComparing(Transaction::getId)).collect(Collectors.toList());
        return transactionList;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
