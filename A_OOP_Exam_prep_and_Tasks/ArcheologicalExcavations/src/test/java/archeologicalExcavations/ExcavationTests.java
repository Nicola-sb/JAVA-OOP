package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {

    @Test(expected = NullPointerException.class)
    public void testNameNullException(){
        Excavation excavation=new Excavation(null,4);
    }
    @Test(expected = NullPointerException.class)
    public void testNameEmptyException(){
        Excavation excavation=new Excavation("",4);
    }
    @Test
    public void testCorrectExcavation(){
        Excavation excavation=new Excavation("Nicola",5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapasitiyUnderZero(){
        Excavation excavation=new Excavation("Nicola",-5);
    }
    //addArchaelogist 3 warianta
    //1.Успешно да си добавя археолога
    //2.Ако нямам капацитет да хвърля грешка
    //3.Ако археолога ми вече е добавен да хвърля грешка
    @Test
    public void testAddCorrectArchaeologist(){
        Excavation excavation=new Excavation("Nicolas",3);
        Archaeologist archaeologist=new Archaeologist("NicolaJR",100);
        Assert.assertEquals(excavation.getCount(),0);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(excavation.getCount(),1);
    }
    @Test(expected =  IllegalArgumentException.class)
    public void testAddArcheologistNoCapacityLeft(){
        Excavation excavation=new Excavation("Nicolas",1);
        Archaeologist archaeologist=new Archaeologist("NicolaJR",100);
        Assert.assertEquals(excavation.getCount(),0);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(excavation.getCount(),1);
        Archaeologist archaeologist1=new Archaeologist("Krisi",91);
        excavation.addArchaeologist(archaeologist1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingArcheologist(){
        Excavation excavation=new Excavation("Nicolas",2);
        Archaeologist archaeologist=new Archaeologist("NicolaJR",100);
        Assert.assertEquals(excavation.getCount(),0);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(excavation.getCount(),1);
        excavation.addArchaeologist(archaeologist);
    }
    @Test
    public void testRemoveArcheoloigst(){
        Excavation excavation=new Excavation("Nicolas",1);
        Archaeologist archaeologist=new Archaeologist("NicolaJR",100);
        Assert.assertEquals(excavation.getCount(),0);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(excavation.getCount(),1);
        excavation.removeArchaeologist(archaeologist.getName());
        Assert.assertEquals(excavation.getCount(),0);
    }
}
