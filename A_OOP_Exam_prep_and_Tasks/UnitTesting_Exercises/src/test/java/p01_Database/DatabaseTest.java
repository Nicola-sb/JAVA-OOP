package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    public DatabaseFirstTask database;//Създравм си обект database
    private static final Integer[]NUMBERS = { 7, 15,24,13,25};

    //1.Конструктор
    //1.1 ДАли създава правилен обект
    //1.2 елементите са > 16
    //1.3 елементите са < 1

    //За да си тествам базартаДанни(databse), първо трябва да си я приготвя
    //В @Before метода ще си подготвя моята база данни(database)
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database=new DatabaseFirstTask(NUMBERS);//Моя обект database = искам да ми стане равен на нов обект,който изпозлва този конструктор и приема масива от чисал NUMBERS
        //Така вече преди да започна да тествам моята базаДанни(database)  ще бъде пълна с някакви числа
        //Създам си един обект от Database  с ето тези числа --> private static final Integer[]NUMBERS = { 7, 15,24,13,25};
    }

    @Test
    public void testConsturctCreateRealObject(){
     //Трябва да видя дали обекта databse се е създал правилно
        //Как ще проверя дали този обект се е създал правилно?
        //1. Трябва да проверя дали обектите които са в database са същите като NUMBERS { 7, 15,24,13,25};
        //1. Проверка на елементите

        //Създавм си масив от цели числа - Elements
        Integer[]elements= database.getElements();//В този масив си държа елементите,които имам в моята БаззаДанни
        //Проверявам си броя на елементите
        Assert.assertArrayEquals(elements,NUMBERS);//Moga da сраввня дали двата масаива са еднакви
        Assert.assertEquals(elements.length,NUMBERS.length);
        //Проверявам дали елементите са същите
        for(int i=0 ;i<elements.length ;i++){
            Assert.assertEquals(elements[i],NUMBERS[i]);//Проврявам дали ако взема от моя масив Element[i] , той ще ми съдвапда с елемента,който се намира в масива
            //NUMbers[i]
        }
    }

    //1.2 елементите са повече от 16
    //•	Storing array's capacity must be exactly 16 integers.
    //o	If the size of the array is not 16 integers long, throw OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        //Какво трябва да тестваме тук?
        //Трябва да тестваме на нашия конструктор,ако му подадем вътре масив,който има повече от 16 елемента,той трявба да хвърле ексепшън
        Integer[]numbers=new Integer[17];//Масив с 17 елемента

          new DatabaseFirstTask(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstrucotrTrowExepctionLessThanOneElement() throws OperationNotSupportedException {
        Integer[]numbers=new Integer[0];
        new DatabaseFirstTask(numbers);
    }

    //2.add
    //2.1 Успешно добавен елемент
    //2.2 Добавяне на null
    //•	Add operation, should add an element at the next free cell. (just like a stack)
    //o	If passed element is null throw OperationNotSupportedException
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        //До момента в моя database аз имам ето тези числа -> { 7, 15,24,13,25};
        database.add(67);
        //Трябва да очаквам да имам ето тези числа -> { 7, 15,24,13,25,67};

        //Първо трябва да проверя дали броя на елементие в database се е увеличил
        Assert.assertEquals(database.getElements().length,NUMBERS.length+1);
        //Методът add ми добавя винаги в края на моята колекция.Трябва да проверя дали на последия елемент в database стой моето число(67);
        Assert.assertEquals(database.getElements()[database.getElements().length-1],Integer.valueOf(67));
    }
    //2.2Добавяне на null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementIsNull() throws OperationNotSupportedException {
        database.add(null);//Oчаквам от метода  database.add(null) да ми хвърли OperationNotSupportedException
    }

    //3.remove
    //3.1 успешно премахване на елемент
    //3.2 премахване на елемент от празна database(elements = [])
    //•	Remove operation, should support only removing an element at the last index. (just like a stack)
    //o	If you try to remove element from empty Database throw OperationNotSupportedException
    @Test
    public void testRemovingElement() throws OperationNotSupportedException {
        //{ 7, 15,24,13,25};
        database.remove();
        //{ 7, 15,24,13};
        Integer[]elements= database.getElements();

        Assert.assertEquals(elements.length,NUMBERS.length-1);
        Assert.assertEquals(elements[elements.length-1],Integer.valueOf(13));
//        Assert.assertEquals(database.getElements()[database.getElements().length-1],Integer.valueOf(13));
    }
    //Премахнване на елемент от празна database
//    @Test(expected = OperationNotSupportedException.class)
//    public void testRemoveThrowEmptyDatabase() throws OperationNotSupportedException {
//        //Искам да си махна всичките елементи --> { 7, 15,24,13,25};
//        for(int i=0 ;i<NUMBERS.length ;i++){
//            database.remove();
//        }
//        //Вече имам празна database
//        database.remove();
//    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExpcetionEmptyArray() throws OperationNotSupportedException {
        database=new DatabaseFirstTask();
        database.remove();
    }

}