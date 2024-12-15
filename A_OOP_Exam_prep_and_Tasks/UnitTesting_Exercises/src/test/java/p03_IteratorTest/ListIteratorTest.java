package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    //1.Първо ше тествам Конструктора
    //1.1 Празен списък с елементи
    //1.2 Списък с елементи
    //Втора HasNext + move
    //
    //3.Трето Print
    //3.1 Празен списък с елементи
    //3.2 Списък с елементи

    private ListIterator listIterator;//Ния тест се характеризира с обекти от типа ListIterator
    //този ListIterator работи с List ot Stringowe
    //--> Създавам си един стартичен Лист от Стрингове -->
    private static final String[] data = {"Nicola", "Krisi", "Mladiq"};

    //Създавам си един @Before клас,който се стартира преди пускането на всеки един тест
    //Нашето полето listIterator искаме да стане равно на обект от клас listIterator,който ми се създава по конструктора(Приема VarArgs от Стрингове)
    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(data);
        //Така всеки път ще казвам,че искам този ListIterator да ми стане на нов обект,който ще ми се създаде от конструктора new ListIterator(data);
    }

    //1.1 Празен списък с елементи
   @Test(expected = OperationNotSupportedException.class)
    public void testConstructorNullException() throws OperationNotSupportedException {
        //Искам да ми извикаш моя конструктор и на него да му подадеш null
        new ListIterator(null);
   }
   //1.2 Списък с елементи
    //Трябва да тествам дали обекта ми listIterator се е създал правилно т.е. дали
    //Не мога да го тествам,защото не мога си взема нито списъка с елементи,нито текущия индекс
    //Теста 1.2 ни отпада,защото не можем да си достъпим списъка с елементи

    //2. hasNext + move
    @Test
    public void testHasNextAndMove(){
        //Имам списък с елементи --> data = {"Nicola", "Krisi", "Mladiq"} - curremtIndex=0
        //Сега ако извикам hasNext(Връща true,ако има слвдващ елемнт)
        //Очаквам в този момента као на listIteratora му извикам hasNExt да ми върне true(Защото имам следващ елемент -> "Криси"
        Assert.assertTrue(listIterator.hasNext());
        //move проверя дали има следващ елемент и го мести и ако има следващ елементи връша true
        Assert.assertTrue(listIterator.move());
        // --> data = {"Nicola", "Krisi", "Mladiq"} - curremtIndex=1  --> Вече текущия ми индекс става 1
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        // --> data = {"Nicola", "Krisi", "Mladiq"} - curremtIndex=1  --> Вече текущия ми индекс става 2

        //Сега вече ако питам hasNext се намирам на последния елемент в списъка и трябва да получа false
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    //3.print
    //3.1 Празен списък с елементи
    @Test(expected = IllegalStateException.class)
    public void testPrintEmtpyList() throws OperationNotSupportedException {
        listIterator=new ListIterator ();
        //Искам моя listIterator да стане нов ListIterato(който обаче е празен,подавам му празен масив от елементи
        listIterator.print();//Oчавкам да хвърли IllegalStateException
    }

    //3.2 Списък с елементи
    @Test
    public void testPrintCorrectly(){
        //data = {"Nicola", "Krisi", "Mladiq"} - curremtIndex=0
        //Докато в моя listIterato имам следващ елемент казвам,че исакм да си проверя дали от листИтератора
        int index=0;
        while (listIterator.hasNext()){
            Assert.assertEquals(listIterator.print(),data[index]);
            index++;
            listIterator.move();
        }
    }



}


