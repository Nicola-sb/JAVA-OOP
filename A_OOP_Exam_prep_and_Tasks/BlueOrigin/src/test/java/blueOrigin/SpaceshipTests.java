package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

    //1.Трябва да си тествам конструктора
    //1.2 сетНаме
    //1.3 сетCapacity
    //1.4 правилно създаден констуктор

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsNullException(){
        Spaceship spaceship=new Spaceship(null,3);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsException(){
        Spaceship spaceship=new Spaceship("",3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCapacitiThrowsException(){
        Spaceship spaceship=new Spaceship("Nicolas",-1);
    }

    //1.add 3 варианта
    //1.2 Успешнп да си го добавя
    //1.3 Ако астронавтите са равни на капацитета хвърля екс
    //1.4 Ако вече имам такъв астронавт хвърлям грешка
    @Test
    public void testCorrectAddAstrounaut(){
        Spaceship spaceship=new Spaceship("Nicolas",3);
        Astronaut astronaut=new Astronaut("Krisi",91);
        Assert.assertEquals(spaceship.getCount(),0);
        spaceship.add(astronaut);
        Assert.assertEquals(spaceship.getCount(),1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingAstronaut(){
        Spaceship spaceship=new Spaceship("Nicolas",3);
        Astronaut astronaut=new Astronaut("Krisi",91);
        Assert.assertEquals(spaceship.getCount(),0);
        spaceship.add(astronaut);
        Assert.assertEquals(spaceship.getCount(),1);
        spaceship.add(astronaut);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreAustraunautsThanCapacity(){
        Spaceship spaceship=new Spaceship("Nicolas",1);
        Astronaut astronaut=new Astronaut("Krisi",91);
        Assert.assertEquals(spaceship.getCount(),0);
        spaceship.add(astronaut);
        Assert.assertEquals(spaceship.getCount(),1);
        Astronaut astronaut2=new Astronaut("Bateto",22);
        spaceship.add(astronaut2);
    }

    //remove
    //1. Успешно да си го премахна
    //1.2 Ако имам такъв астронавт вече да си го премахна
    @Test
    public void testCorrectRemove(){
        Spaceship spaceship=new Spaceship("Nicolas",3);
        Astronaut astronaut=new Astronaut("Krisi",91);
        Assert.assertEquals(spaceship.getCount(),0);
        spaceship.add(astronaut);
        Assert.assertEquals(spaceship.getCount(),1);
        spaceship.remove(astronaut.getName());
        Assert.assertEquals(spaceship.getCount(),0);
    }

//    @Test
//    public void testRemoveExistingAstronaut(){
//        Spaceship spaceship=new Spaceship("Nicolas",3);
//        Astronaut astronaut=new Astronaut("Krisi",91);
//        Assert.assertEquals(spaceship.getCount(),0);
//        spaceship.add(astronaut);
//        Assert.assertEquals(spaceship.getCount(),1);
//    }

}
