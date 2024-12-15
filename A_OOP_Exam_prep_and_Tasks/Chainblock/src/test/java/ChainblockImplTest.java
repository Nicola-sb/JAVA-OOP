import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
 private Chainblock database;
 private List<Transaction>transactionList;

  @Before
    public void setUp(){
     this.database=new ChainblockImpl();//създавм си празна база данни
      this.transactionList=new ArrayList<>();
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

    //•	add() – Add a transaction to the record. You will need to implement the contains(Transaction)
    // methods as well you need to store only unique transactions by id.
    //add Имам 2 вариант --> 1.Транзакция,която я няма   2.Транзакция,която я има
    @Test
    public void testAddCorrectTransaction(){
      //В момента имаме 0 транзакции
        Assert.assertEquals(0,this.database.getCount());
        this.database.add(transactionList.get(0));
        Assert.assertEquals(1,this.database.getCount());
        //Вече имам 1 транзакция
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.FAILED,"Nicola","Emil",150.50);
        this.database.add(transaction2);
        Assert.assertEquals(2,this.database.getCount());
        //Вече имам 2 транзакции
    }
    //Test w който си проверяваме в който си слагаме транзакцията,която я има
    @Test
    public void testAddExistingTransaction(){
        Assert.assertEquals(0,this.database.getCount());
        this.database.add(transactionList.get(0));
        Assert.assertEquals(1,this.database.getCount());
        this.database.add(transactionList.get(0));//Тук очакваме броя на  транзакциите да не се е променил
        Assert.assertEquals(1,this.database.getCount());//Нашият адд добавя само транзакция,която я няма
    }
    //•	contains(Transaction) – checks if a given transaction is present in the record. Keep in mind that transaction id is the only unique identifier.
    //•	contains(id) – checks if a transaction with the given id exists in the record
    //Обединяваме двата метода contains в един тест
    //contains -> true ако имаме такава транзакция в database
    @Test
    public void testContains(){
        //В момента имам 0 транзакции
        //Ако си извикам метода contains трябва да ми върне false понеже вътре нямам никакви транзакции
        Assert.assertFalse(this.database.contains(transactionList.get(0)));//testvam contains по транзакция
        Assert.assertFalse(this.database.contains(transactionList.get(0).getId()));//testvam contains по id

        this.database.add(transactionList.get(0));
        Assert.assertTrue(this.database.contains(transactionList.get(0)));//testvam contains по транзакция
        Assert.assertTrue(this.database.contains(transactionList.get(0).getId()));//testvam contains по id
    }
    //•	changeTransactionStatus(id, status) – changes the status of the transaction with the given id or throws
    // IllegalArgumentException if no such transaction exists
    //changeTransactionStatus трябва да сменим статуса на транзакцията с даденото id или да хвърлим грешка
    //1.Намираме транзакция с даденото ид -> сменяме и статуса
    @Test
    public void testChangeTransactionStatus(){
        this.database.add(transactionList.get(0));
        Assert.assertEquals(1,database.getCount());
        this.database.changeTransactionStatus(1,TransactionStatus.FAILED);
        Assert.assertEquals(TransactionStatus.FAILED,transactionList.get(0).getStatus());
    }
    //2.НЕ намираме транзакция с даденото id
    @Test(expected = IllegalArgumentException.class)
    public void testTransactionStatusWithInvalidId(){
        this.database.add(transactionList.get(0));
        Assert.assertEquals(1,database.getCount());
        this.database.changeTransactionStatus(2,TransactionStatus.FAILED);
    }
    //•	removeTransactionById(id) – remove the transaction from the record if the id exists, otherwise throws IllegalArgumentException.
    @Test
    public void testRemoveTransactionByExistingId(){
      //Имам 0 транзакции
        this.database.add(this.transactionList.get(0));
        this.database.add(this.transactionList.get(1));
        Assert.assertEquals(2,this.database.getCount());
        //Имам 2 транзакции
        int id=this.transactionList.get(0).getId();
        this.database.removeTransactionById(id);
        //Имам 1 транзакция
        Assert.assertEquals(1,this.database.getCount());
        Assert.assertFalse(this.database.contains(id));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsException(){
        this.database.add(this.transactionList.get(0));
        this.database.removeTransactionById(5);
    }
    //•	getById(id) – return the transaction with the given id. If such transaction doesn't exist, throw IllegalArgumentException.
    @Test
    public void testGetById(){
      Transaction transaction=transactionList.get(0);
      this.database.add(transaction);
        //Имам 1 транзакция
        Transaction returnedTransaction=this.database.getById(transaction.getId());
        //Проверка дали получената транзакция = подадената транзакция
//       1.Вариант Assert.assertEquals(transaction,returnedTransaction);
        Assert.assertEquals(transaction.getId(),returnedTransaction.getId());
        Assert.assertEquals(transaction.getStatus(),returnedTransaction.getStatus());
        Assert.assertEquals(transaction.getFrom(),returnedTransaction.getFrom());
        Assert.assertEquals(transaction.getTo(),returnedTransaction.getTo());
        Assert.assertEquals(transaction.getAmount(),returnedTransaction.getAmount(),0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowsExceptionInvalidId(){
      this.database.add(transactionList.get(0));
      this.database.getById(5);
    }
    //•	getByTransactionStatus(status) – return the transactions with the given status ordered by amount descending.
    // If there are no transactions with the given status, throw IllegalArgumentException.
   //Трябва да ми върне списък с всички транзакции подредени по amount по descending order
    //1.Подаваме валиден статус -> връща всички транзакции с този статус подредени по amount na descending
    //2.Невалиден статус - хвърляме exception
    @Test
    public void testGetByTransactionStatus(){
      List<Transaction>successfulTransactions=this.transactionList.stream().
      filter(transaction -> transaction.getStatus()==TransactionStatus.SUCCESSFUL).collect(Collectors.toList());//списък само с успешни транзакции
        fillDatabaseWithTransaction();
        Iterable<Transaction>result=database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction>returnedTransaction=new ArrayList<>();//Списък с върнатите  транзакции
        result.forEach(returnedTransaction::add);
        //броя на върнатие е правилен
        Assert.assertEquals(successfulTransactions.size(),returnedTransaction.size());
        //дали всички върнати са successfull
        returnedTransaction.forEach(transaction -> Assert.assertEquals(TransactionStatus.SUCCESSFUL,transaction.getStatus()));
        //проверка дали е сортиран по amount
        Assert.assertEquals(successfulTransactions,returnedTransaction);
    }

    private void fillDatabaseWithTransaction() {
        //0 транзакции
        this.database.add(transactionList.get(2));
        this.database.add(transactionList.get(1));
        this.database.add(transactionList.get(0));
        //3 транзакции
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowsException(){
        fillDatabaseWithTransaction();
        this.database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }
    //•	getAllSendersWithTransactionStatus(status) – returns all senders which have transactions with the given
    // status ordered by transactions amount (if there are multiple transactions with the same sender, return them all).
    // If no transactions exist, throw IllegalArgumentException.
   //1.ДА връща получателите подредени по брой транзакции
    @Test
    public void testGetAllSendersWithTransactionStatus(){
         fillDatabaseWithTransaction();
         this.database.add(new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Baceto","Krisi",1550));
        //4 транзакции
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        //Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Baceto","Krisi",1550);
        Iterable<String>result=this.database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Baceto","Krisi",1550);
        List<String>returnedSenders=new ArrayList<>();
        result.forEach(returnedSenders::add);
        //expected transactions
        //Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Baceto","Krisi",1550);
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        Assert.assertEquals(3,returnedSenders.size());
        Assert.assertEquals("Baceto",returnedSenders.get(0));
        Assert.assertEquals("Nicola",returnedSenders.get(1));
        Assert.assertEquals("Nicola",returnedSenders.get(2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowsException(){
      fillDatabaseWithTransaction();
      this.database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }
    //•	getAllOrderedByAmountDescendingThenById() – returns all transactions ordered by amount descending and by id.
    @Test
    public void testGetAllOrderedByAmountDescendingThenByID(){
        fillDatabaseWithTransaction();
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<Transaction>iterable=this.database.getAllOrderedByAmountDescendingThenById();
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        List<Transaction>result=new ArrayList<>();
        iterable.forEach(result::add);
        List<Transaction>expected=this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Assert.assertEquals(result,expected);
    }
    //•	getBySenderOrderedByAmountDescending(sender) – search for all transactions with a specific sender and return them ordered by amount descending.
    // If there are no such transactions throw IllegalArgumentException.
    @Test
    public void testGetBySenderOrderedByAmountDescending(){
         //search for all transactions with a specific sender and return them ordered by amount descending.
        // If there are no such transactions throw IllegalArgumentException.
        fillDatabaseWithTransaction();
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        //Transaction transaction3=new TransactionImpl(3,TransactionStatus.FAILED,"Nicola","Petar",100.50);
        Iterable<Transaction>transactions=this.database.getBySenderOrderedByAmountDescending("Nicola");
        List<Transaction>transactionList1=new ArrayList<>();
        transactions.forEach(transactionList1::add);
        //Transaction transaction1=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Nicola","Stoyan",150.50);
        //Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Nicola","Emil",120.50);
        List<Transaction>expectedList=transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        Assert.assertEquals(expectedList,transactionList1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingThrowsException(){
      fillDatabaseWithTransaction();
      Iterable<Transaction>iterable=this.database.getBySenderOrderedByAmountDescending("sadsa");
    }

}