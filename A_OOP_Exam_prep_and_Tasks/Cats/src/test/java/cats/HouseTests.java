package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HouseTests {

    private House house;

    private Cat persian;
    private Cat arabian;
    private Cat american;

    @Before
    public void setup(){
        this.house=new House("Nicola'sHouse",2);
        persian=new Cat("Persian");
        arabian=new Cat("Arabian");
        american=new Cat("American");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGreatherHouseWithInvalidCapacity(){
        House house1=new House("Pri Baceto",-4);
    }
    @Test(expected = NullPointerException.class)
    public void testHouseInvalidName(){
        House house1=new House("",4);
    }
    @Test(expected = NullPointerException.class)
    public void testHouseNull(){
        House house1=new House(null,4);
    }
    @Test
    public void testGrateHouse(){
        House house1=new House("Baceto",4);
        Assert.assertEquals(4,house1.getCapacity());
        Assert.assertEquals("Baceto",house1.getName());
    }
    @Test
    public void testAddCorrectly(){
        Assert.assertEquals(house.getCount(),0);
        house.addCat(persian);
        house.addCat(arabian);
        Assert.assertEquals(house.getCount(),2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsException(){
        house.addCat(persian);
        house.addCat(arabian);
        house.addCat(american);
    }

    @Test
    public void testRemoveCat(){
        // persian=new Cat("Persian");
        // arabian=new Cat("Arabian");
        // american=new Cat("American");
        House house1=new House("Nicola'sHouse",3);
        house1.addCat(persian);
        house1.addCat(arabian);
        house1.addCat(american);
        Assert.assertEquals(house1.getCount(),3);
        house1.removeCat("Persian");
        Assert.assertEquals(house1.getCount(),2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsException(){
        House house=new House("Nicola'sHouse",3);
        house.removeCat("Gosho");
    }
    @Test
    public void testCatForSale(){
        house.addCat(persian);
        house.addCat(arabian);
        Cat catForSale=house.catForSale("Persian");
        Assert.assertFalse(catForSale.isHungry());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsException(){
      house.catForSale("Pesho");
    }

    @Test
    public void testGetStatistics(){
        house.addCat(persian);
        house.addCat(arabian);

        Assert.assertEquals("The cat Persian, Arabian is in the house Nicola'sHouse!",house.statistics());
    }

}
