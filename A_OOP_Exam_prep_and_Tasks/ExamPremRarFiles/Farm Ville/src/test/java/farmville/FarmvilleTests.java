package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    private Farm farm;
    private Animal lion;
    private Animal tiger;

    @Before
    public void setup(){
        farm=new Farm("Fermata",11);
        lion=new Animal("Lion",100);
        tiger=new Animal("Tiger",99);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameEmtypName(){
        Farm farm1=new Farm("",1);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameNullNameException(){
        Farm farm1=new Farm(null,1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCapacityUnderZero(){
        Farm farm1=new Farm("Fermata",-5);
    }

    @Test
    public void testAddCorrectAnimal(){
        Assert.assertEquals(0,farm.getCount());
        farm.add(lion);
        farm.add(tiger);
        Assert.assertEquals(2,farm.getCount());
        Assert.assertEquals(farm.getName(),"Fermata");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testThrowExcpetionNoPlaceForAnimal(){
        Farm farm12=new Farm("Fermata",1);
        farm12.add(tiger);
        farm12.add(lion);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addAniamlExistThrowsException(){
        farm.add(lion);
        farm.add(lion);
    }
    @Test
    public void testRemoveAnimal(){
        farm.add(lion);
        farm.add(tiger);
        Assert.assertEquals(2,farm.getCount());
        farm.remove(tiger.getType());
        Assert.assertEquals(1,farm.getCount());
    }

}
