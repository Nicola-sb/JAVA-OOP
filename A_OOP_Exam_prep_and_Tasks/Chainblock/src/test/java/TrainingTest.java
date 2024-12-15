import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingTest {

    private Chainblock database;
    private List<Transaction>transactionList;
    @Before
    public void setUp(){
        this.database=new ChainblockImpl();
        transactionList=new ArrayList<>();
        prepareTransaction();
    }
    private void prepareTransaction() {
        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        this.transactionList.add(transaction1);
        this.transactionList.add(transaction2);
        this.transactionList.add(transaction3);
    }

    //•	getByTransactionStatus(status) – return the transactions with the given status ordered by amount descending.
    // If there are no transactions with the given status, throw
    @Test
    public void testGetByTransactionStatus(){
           List<Transaction>suceesfuulTransaction= transactionList.stream().
           filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL)
           .collect(Collectors.toList());//Остават ми само транзакции със статус successful
        fillDatabaseWithTransaction();
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        Iterable<Transaction>result=database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction>returnedTransaction=new ArrayList<>();
        result.forEach(returnedTransaction::add);
        Assert.assertEquals(suceesfuulTransaction.size(),returnedTransaction.size());
        returnedTransaction.forEach(transaction -> Assert.assertEquals(TransactionStatus.SUCCESSFUL,transaction.getStatus()));
        Assert.assertEquals(suceesfuulTransaction,returnedTransaction);

    }
    private void fillDatabaseWithTransaction() {
        //0 транзакции
        this.database.add(transactionList.get(2));
        this.database.add(transactionList.get(1));
        this.database.add(transactionList.get(0));
        //3 транзакции
    }
    @Test
    public void testGetByTransactionStatusFirst(){
        //1.
        List<Transaction>succesfullTransaction=transactionList.stream()
        .filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL).collect(Collectors.toList());
        //Държа си всички транзакции със статус successfull
        //2.
        fillDatabaseWithTransaction();
        //3.
        Iterable<Transaction>resultTr=database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        //4.
        List<Transaction>returnedTransaction=new ArrayList<>();
        //5.
        resultTr.forEach(returnedTransaction::add);
        //6.
        Assert.assertEquals(succesfullTransaction.size(),returnedTransaction.size());
        //7.
        resultTr.forEach(transaction -> Assert.assertEquals(transaction.getStatus(),TransactionStatus.SUCCESSFUL));
        //8.
        Assert.assertEquals(succesfullTransaction,returnedTransaction);
    }
    @Test
    public void testGetByTransactionStatusFirstThrowsException(){
        fillDatabaseWithTransaction();
        this.database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }
    @Test
    public void testGetByTransactionStatusSecond(){
        //1.
        List<Transaction>successfullTransaction=
        transactionList.stream().filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL).collect(Collectors.toList());
        //2.
        fillDatabaseWithTransaction();
        //3.
        Iterable<Transaction>result=this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        //4.
        List<Transaction>returnedTransaction=new ArrayList<>();
        //5.
        result.forEach(returnedTransaction::add);
        //6.
        Assert.assertEquals(successfullTransaction.size(),returnedTransaction.size());
        //7.
        returnedTransaction.forEach(transaction -> Assert.assertEquals(transaction.getStatus(),TransactionStatus.SUCCESSFUL));
        //8.
        Assert.assertEquals(returnedTransaction,successfullTransaction);
    }
    @Test
    public void testGetByTransactionStatusThird(){
        //1.
        List<Transaction>successfullTransaction=transactionList.stream().filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL)
        .collect(Collectors.toList());
        //2.
        this.database.add(transactionList.get(2));
        this.database.add(transactionList.get(1));
        this.database.add(transactionList.get(0));
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        //3.
        Iterable<Transaction>result=database.getByTransactionStatus(TransactionStatus.FAILED);
        //4.
        List<Transaction>returnedTransaction=new ArrayList<>();
        //5.
        result.forEach(returnedTransaction::add);
        //6.
        Assert.assertEquals(successfullTransaction.size(),returnedTransaction.size());
        //7.
        returnedTransaction.forEach(transaction -> Assert.assertEquals(transaction.getStatus(),TransactionStatus.FAILED));
        //8.
        Assert.assertEquals(successfullTransaction,returnedTransaction);
    }

    //•	add() – Add a transaction to the record.
    // You will need to implement the contains(Transaction) methods as well you need to store only unique transactions by id.
    @Test
    public void testAdd(){
        Assert.assertEquals(this.database.getCount(),0);
        fillDatabaseWithTransaction();
        Assert.assertEquals(this.database.getCount(),3);
    }
    @Test
    public void testAddInvalindTransaction(){
        Assert.assertEquals(this.database.getCount(),0);
        fillDatabaseWithTransaction();
        Assert.assertEquals(this.database.getCount(),3);
        this.database.add(transactionList.get(1));
        Assert.assertEquals(this.database.getCount(),3);
    }
    //•	contains(Transaction) – checks if a given transaction is present in the record. Keep in mind that transaction id is the only unique identifier.
    //•	contains(id) – checks if a transaction with the given id exists in the record.
    @Test
    public void testContainsTransaction(){
        //В момента имам 0 транзакции
        //Ако си извикам метода contains трябва да ми върне false понеже вътре нямам никакви транзакции
        Assert.assertFalse(this.database.contains(transactionList.get(0)));//testvam contains по транзакция
        Assert.assertFalse(this.database.contains(transactionList.get(0).getId()));//testvam contains по id

        this.database.add(transactionList.get(0));
        Assert.assertTrue(this.database.contains(transactionList.get(0)));//testvam contains по транзакция
        Assert.assertTrue(this.database.contains(transactionList.get(0).getId()));//testvam contains по id
    }
    //•	changeTransactionStatus(id, status) – changes the status of the transaction with the given id or
    // throws IllegalArgumentException if no such transaction exists.
    @Test
    public void testChangeTransactionStatus(){
        fillDatabaseWithTransaction();
        this.database.changeTransactionStatus(1,TransactionStatus.SUCCESSFUL);
        Assert.assertEquals(this.transactionList.get(1).getStatus(),TransactionStatus.SUCCESSFUL);
    }
    //•	getAllSendersWithTransactionStatus(status) – returns all senders which have transactions with the given status ordered by transactions amount (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
    //Example:
    //	"Sam" has 3 sent transactions -> 2 of them successful (5 leva and 6 leva sent) and 1 aborted transaction.
    //	"Peter" has 1 sent transaction and it is successful (2leva sent).
    //	The result of the call should be "Sam", "Sam", "Peter".
    @Test
    public void testGetAllSendersWithTransactionStatus(){
        fillDatabaseWithTransaction();
        this.database.add(new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Krisi","Petar",1555));
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        //new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Krisi","Petar",1555));
        Iterable<String>senders=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        //new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Krisi","Petar",1555));
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        List<String>sendersList=new ArrayList<>();
        senders.forEach(sendersList::add);
        Assert.assertEquals(sendersList.size(),3);
        Assert.assertEquals(sendersList.get(0),"Krisi");
        Assert.assertEquals(sendersList.get(1),"Nicola");
        Assert.assertEquals(sendersList.get(2),"Nicola");
    }
    @Test
    public void testGetAllSendersWithTransactionStatus1(){
        fillDatabaseWithTransaction();
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        // Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<String>senders=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        List<String>sendersList=new ArrayList<>();
        senders.forEach(sendersList::add);
        Assert.assertEquals(sendersList.size(),2);
        Assert.assertEquals(sendersList.get(0),"Nicola");
        Assert.assertEquals(sendersList.get(1),"Nicola");
    }
    @Test
    public void testGetAllSendersWithTransactionStatus2(){
        fillDatabaseWithTransaction();
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        // Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        this.database.add(new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Krisi","adsa",15555));
        this.database.add(new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Gosho","adsa",15));
        Iterable<String>senders=this.database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        //new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Krisi","adsa",15555));
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Gosho","adsa",15));
        List<String>sendersList=new ArrayList<>();
        senders.forEach(sendersList::add);
        Assert.assertEquals(sendersList.size(),4);
        Assert.assertEquals(sendersList.get(0),"Krisi");
        Assert.assertEquals(sendersList.get(1),"Nicola");
        Assert.assertEquals(sendersList.get(2),"Nicola");
        Assert.assertEquals(sendersList.get(3),"Gosho");

    }
    @Test
    public void testGetAllSendersWithTransactionStatus3(){
       //getAllSendersWithTransactionStatus(status) – returns all senders which have transactions with the given status ordered by transactions amount
        // (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        fillDatabaseWithTransaction();
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        // Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<String>result=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        List<String>sendersList=new ArrayList<>();
        result.forEach(sendersList::add);
        Assert.assertEquals(sendersList.size(),2);
        Assert.assertEquals(sendersList.get(0),"Nicola");
        Assert.assertEquals(sendersList.get(1),"Nicola");
    }
    @Test
    public void testGetByTransactionStatus1(){
        //•	getByTransactionStatus(status) – return the transactions with the given status ordered by amount descending.
        // If there are no transactions with the given status, throw IllegalArgumentException.
        List<Transaction>transactionList1=this.transactionList.stream().filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL)
        .collect(Collectors.toList());
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //2.
        fillDatabaseWithTransaction();
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        // Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        //3.
        Iterable<Transaction>iterable=this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        // Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        // Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //4
        List<Transaction>result=new ArrayList<>();
        iterable.forEach(result::add);
        Assert.assertEquals(transactionList1.size(),result.size());
        result.forEach(transaction -> Assert.assertEquals(transaction.getStatus(),TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(result,transactionList1);
    }
    @Test
    public void testGetAllOrderedByAmountDescendingThenByID(){
             fillDatabaseWithTransaction();
//        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
//        Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<Transaction>result=this.database.getAllOrderedByAmountDescendingThenById();
//        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
//        Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        List<Transaction>resulList=new ArrayList<>();
        result.forEach(resulList::add);

        List<Transaction>expectedTr=this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId)).collect(Collectors.toList());

        Assert.assertEquals(expectedTr,resulList);
    }
    @Test
    public void testAdd1(){
        Assert.assertEquals(0,this.database.getCount());
        fillDatabaseWithTransaction();
        Assert.assertEquals(3,this.database.getCount());
    }
    @Test
    public void testAddWithInvalidTransaction(){
        Assert.assertEquals(0,this.database.getCount());
        fillDatabaseWithTransaction();
        Assert.assertEquals(3,this.database.getCount());
        this.database.add(new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50));
        Assert.assertEquals(3,this.database.getCount());
    }
//•	contains(Transaction) – checks if a given transaction is present in the record. Keep in mind that transaction id is the only unique identifier.
//•	contains(id) – checks if a transaction with the given id exists in the record.
    @Test
    public void testContains(){
        Assert.assertFalse(this.database.contains(transactionList.get(0).getId()));
        Assert.assertFalse(this.database.contains(transactionList.get(0)));
        // Assert.assertFalse(this.database.contains(transactionList.get(0)));//testvam contains по транзакция
        // Assert.assertFalse(this.database.contains(transactionList.get(0).getId()));//testvam contains по id
        fillDatabaseWithTransaction();
        Assert.assertTrue(this.database.contains(transactionList.get(0).getId()));
        Assert.assertTrue(this.database.contains(transactionList.get(0)));
    }
    // changes the status of the transaction with the given id or throws IllegalArgumentException if no such transaction exists.
    @Test
    public void testChangeTransactionStatus1(){
        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.5);
        this.database.add(transaction1);
        Assert.assertEquals(1,database.getCount());
        this.database.changeTransactionStatus(1,TransactionStatus.FAILED);
        Assert.assertEquals(transaction1.getStatus(),TransactionStatus.FAILED);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeTranThrowException(){
        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.5);
        this.database.add(transaction1);
        this.database.changeTransactionStatus(2,TransactionStatus.SUCCESSFUL);
    }
    //•	removeTransactionById(id) – remove the transaction from the record if the id exists, otherwise throws IllegalArgumentException.
    @Test
    public void testRemoveTransationById(){
        fillDatabaseWithTransaction();
//        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
//        Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Assert.assertEquals(3,this.database.getCount());
        int id=this.transactionList.get(0).getId();
        this.database.removeTransactionById(id);
        Assert.assertEquals(2,this.database.getCount());
        Assert.assertFalse(this.database.contains(id));
    }
    //•	getByTransactionStatus(status) – return the transactions with the given status ordered by amount descending.
    // If there are no transactions with the given status, throw IllegalArgumentException
    @Test
    public void testGetByTransactionStatus12(){
        List<Transaction>firstList=this.transactionList.stream()
                .filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL).collect(Collectors.toList());
        fillDatabaseWithTransaction();
//        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
//        Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<Transaction>transactions=this.database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        //3.
        List<Transaction>secondList=new ArrayList<>();
        transactions.forEach(secondList::add);
        //        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        Assert.assertEquals(firstList.size(),secondList.size());
        firstList.forEach(transaction -> Assert.assertEquals(TransactionStatus.SUCCESSFUL,transaction.getStatus()));
        Assert.assertEquals(firstList,secondList);
    }
    //returns all senders which have transactions with the given status ordered by transactions amount
    // (if there are multiple transactions with the same sender, return them all).
    // If no transactions exist, throw IllegalArgumentException.
    @Test
    public void testGetAllSendersWithTransactionStatus12(){
        fillDatabaseWithTransaction();
        Iterable<String>iterable=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
//        Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
//        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);

        List<String>returnedTr=new ArrayList<>();
        iterable.forEach(returnedTr::add);

        Assert.assertEquals(2,returnedTr.size());
        Assert.assertEquals("Nicola",returnedTr.get(0));
        Assert.assertEquals("Nicola",returnedTr.get(1));
    }
    @Test
    public void testGetAllSendersWithTransactionStatus121(){
//•	getAllSendersWithTransactionStatus(status) – returns all senders which have transactions with the given status ordered by transactions amount
// (if there are multiple transactions with the same sender, return them all).  If no transactions exist, throw IllegalArgumentException.
        fillDatabaseWithTransaction();
        Iterable<String>transactions=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String>returnedTransaction=new ArrayList<>();
        transactions.forEach(returnedTransaction::add);
        Assert.assertEquals(returnedTransaction.size(),2);
        Assert.assertEquals(returnedTransaction.get(0),"Nicola");
        Assert.assertEquals(returnedTransaction.get(1),"Nicola");
    }
}
