package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    public Database database;//Създравм си обект database
    private static final Person[]PEOPLE = {new Person(1,"Nicola"),new Person(2,"Krisi"),new Person(3,"KrisiJunior")};

    //1.Конструктор
    //1.1 ДАли създава правилен обект
    //1.2 елементите са > 16
    //1.3 елементите са < 1

    //За да си тествам базартаДанни(databse), първо трябва да си я приготвя
    //В @Before метода ще си подготвя моята база данни(database)
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database=new Database(PEOPLE);//Моя обект database = искам да ми стане равен на нов обект,който изпозлва този конструктор и приема масива от чисал NUMBERS
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
        Person[]elements= database.getElements();//В този масив си държа елементите,които имам в моята БаззаДанни
        //Проверявам си броя на елементите
        Assert.assertArrayEquals(elements,PEOPLE);//Moga da сраввня дали двата масаива са еднакви
        Assert.assertEquals(elements.length,PEOPLE.length);
        //Проверявам дали елементите са същите
        for(int i=0 ;i<elements.length ;i++){
            Assert.assertEquals(elements[i],PEOPLE[i]);//Проврявам дали ако взема от моя масив Element[i] , той ще ми съдвапда с елемента,който се намира в масива
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
        Person[]people=new Person[17];//Масив с 17 елемента

        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstrucotrTrowExepctionLessThanOneElement() throws OperationNotSupportedException {
        Person[]people=new Person[0];
        new Database(people);
    }

    //2.add
    //2.1 Успешно добавен елемент
    //2.2 Добавяне на null

    //If there are multiple users with this id, throw OperationNotSupportedException.
    // 	If negative nor null ids are present, throw OperationNotSupportedException.
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        //До момента в моя database аз имам ето тези хора -> {new Person(1,"Nicola"),new Person(2,"Krisi"),new Person(3,"KrisiJunior")};
        database.add(new Person(4,"Desi"));//Към този масив искам да ми добавиш нов човек,който е id 4 и име Деси
        //Трябва да очаквам да имам ето тези хора {new Person(1,"Nicola"),new Person(2,"Krisi"),new Person(3,"KrisiJunior"),4."Desi"};

        //Първо си взимам списъка с хората и след това проверявам дали списъка с хората след добавянето е равен на първоначлния списък + 1
        //Първо трябва да проверя дали броя на хората е равен на първоначлни списък + 1
        Person[]people= database.getElements();
        Assert.assertEquals(people.length,PEOPLE.length+1);
        //Трябва да проверя дали на последно място в моя списък ми стой "Desi"
        //Трябва да проверя на последно място в моя списък дали ми стои "Desi"-->
        //На последно място,човека които стои,ако взема неговото Id дали отговоря на 4
        Assert.assertEquals(Integer.valueOf(people[people.length-1].getId()),Integer.valueOf(4));//Проверявам дали Id-то на последния човек в списък отговаря на 4
        //Също мога да проверя дали ако взема името Integer.valueOf(people[people.length-1].getUsername() ще бъде равно на "Desi"
        Assert.assertEquals(people[people.length-1].getUsername(),"Desi");
    }
    //2.2Добавяне на null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementIsNull() throws OperationNotSupportedException {
        database.add(null);//Oчаквам от метода  database.add(null) да ми хвърли OperationNotSupportedException
    }

    //3.remove
    //3.1 успешно премахване на човек
    //	findByUsername
    //	If no user is present by this username, throw OperationNotSupportedException.
    // If username parameter is null, throw OperationNotSupportedException.
    //	Arguments are all CaseSensitive!

    @Test
    public void testRemovingPerson() throws OperationNotSupportedException {
      //{new Person(1,"Nicola"),new Person(2,"Krisi"),new Person(3,"KrisiJunior")};
        database.remove();
        //{new Person(1,"Nicola"),new Person(2,"Krisi");
        Person[]elements= database.getElements();

        Assert.assertEquals(elements.length,PEOPLE.length-1);
        Assert.assertEquals(elements[elements.length-1].getUsername(),"Krisi");
        Assert.assertEquals(Integer.valueOf(elements[elements.length-1].getId()),Integer.valueOf(2));
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
        database=new Database();
        database.remove();
    }

    //4.find by username
    //4.1 Ако подадеме null

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameCatchNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    //4.2 Ако подам валиден username
    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        //1.Nicola,2.Krisi,3.KrisiJunior
        Person person=database.findByUsername("Nicola");//Очаквам този метод да ми върне един човек("Nicola")
        //Какво трябва да му проверя на този човек(username)?
        //username = "Nicola";
        //id = 1;
        //--> Провери ми на човек дали неговот id = 1
        Assert.assertEquals(person.getId(),1);
        Assert.assertEquals(person.getUsername(),"Nicola");
    }


    //4.3 Ако нямаме хора в database
    @Test(expected = OperationNotSupportedException.class)
    public void testNoPeopleInOurDatabase() throws OperationNotSupportedException {
        database=new Database();
        database.findByUsername("Nicola");
    }
    //4.4 Ако намерим 2ма човека с това име
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
      ////1.Nicola,2.Krisi,3.KrisiJunior
        database.add(new Person(4,"Nicola"));

        database.findByUsername("Nicola");
    }

    //4.5 Ако нямаме човек с това име
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameLessThanOne() throws OperationNotSupportedException {
        ////1.Nicola,2.Krisi,3.KrisiJunior
        database.findByUsername("Koko");
    }

    //5. find by ID
    //If no user is present by this id, throw OperationNotSupportedException.
    //5.1 Ако подадем валидно id
    @Test
    public void testFindById() throws OperationNotSupportedException {
        //////1.Nicola,2.Krisi,3.KrisiJunior
        Person person=database.findById(1);
        //Искам да си създам един Person,Който го взимам от моята database и си взимам човека с id 1 (С id 1 e Nicola)
        //Трябва да проверя дали persona,който се е взел от database.findById е точно Nicola
        Assert.assertEquals(person.getId(),1);
        Assert.assertEquals(person.getUsername(),"Nicola");
        database.findById(2);
    }
    //5.2 Ако намерим повече от един човек с това id
    @Test(expected = OperationNotSupportedException.class)
    public void testMoreThanOnePersonWithId() throws OperationNotSupportedException {
        //////1.Nicola,2.Krisi,3.KrisiJunior
        database.add(new Person(1,"Petkan"));
        database.findById(1);
    }
    //5.3 празен database
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmtpyData() throws OperationNotSupportedException {
        database=new Database();
        database.findById(1);
    }


}