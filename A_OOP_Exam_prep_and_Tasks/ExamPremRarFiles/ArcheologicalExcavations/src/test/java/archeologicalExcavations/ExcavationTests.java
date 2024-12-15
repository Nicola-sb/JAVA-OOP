package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

    private Excavation excavation;

    private  Archaeologist bioArcheo;
    private  Archaeologist starArcheologist;

    @Before
    public void setup(){
        excavation=new Excavation("NicolasExcavation",6);
        bioArcheo=new Archaeologist("Pesho",100);
        starArcheologist=new Archaeologist("Gosho",99);
    }

    @Test
    public void testGetCount(){
        excavation.addArchaeologist(bioArcheo);
        excavation.addArchaeologist(starArcheologist);
        Assert.assertEquals(2,excavation.getCount());
        Assert.assertEquals(bioArcheo.getName(),"Pesho");
    }
    @Test
    public void testAddCorrectArcheologist(){
        Assert.assertEquals(0,excavation.getCount());
        excavation.addArchaeologist(bioArcheo);
        Assert.assertEquals(1,excavation.getCount());
        Assert.assertEquals(excavation.getName(),"NicolasExcavation");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsException(){
        excavation.addArchaeologist(bioArcheo);
        excavation.addArchaeologist(bioArcheo);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionNoCapacityLeft(){
        Excavation excavation1=new Excavation("Niki",1);
        excavation1.addArchaeologist(bioArcheo);
        excavation1.addArchaeologist(starArcheologist);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionNoCapacityZerocap(){
        Excavation excavation1=new Excavation("Niki",-2);
        excavation1.addArchaeologist(bioArcheo);
        excavation1.addArchaeologist(starArcheologist);
    }
    @Test(expected = NullPointerException.class)
    public void testNameThrowExcpetion(){
        Excavation excavation1=new Excavation(null,1);
    }
    @Test(expected = NullPointerException.class)
    public void testNameThrowNullExcpetion(){
        Excavation excavation1=new Excavation("",1);
    }
    @Test
    public void testRemoveArcheologistCorrectly(){
        excavation.addArchaeologist(bioArcheo);
        excavation.addArchaeologist(starArcheologist);
        excavation.removeArchaeologist(bioArcheo.getName());
        Assert.assertEquals(1,excavation.getCount());
    }
}
