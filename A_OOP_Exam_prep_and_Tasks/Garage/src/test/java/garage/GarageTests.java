package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Car porshe;
    private Car mercedes;
    private Car huindai;

     private Garage garage;
     @Before
     public void setup(){
          this.garage=new Garage();
          porshe=new Car("Porshe",259,13333);
          mercedes=new Car("Mercedes",349,25000);
          huindai=new Car("Huindai",202,9999);
     }

    @Test
    public void testAddCars(){
        Assert.assertEquals(0,garage.getCount());
        garage.addCar(porshe);
        Assert.assertEquals(1,garage.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCarsThrowException(){
        garage.addCar(null);
    }
    @Test
    public void testGetGars(){
         garage.addCar(porshe);
         garage.addCar(mercedes);
         List<Car>carList=garage.getCars();
         Assert.assertEquals(garage.getCount(),2);
         Assert.assertEquals(porshe.getBrand(),carList.get(0).getBrand());
    }
    @Test
    public void testCarfindAllCarsWithMaxSpeedAbove(){
         garage.addCar(porshe);
         garage.addCar(mercedes);
         garage.addCar(huindai);
         List<Car>carList=garage.findAllCarsWithMaxSpeedAbove(200);

         Assert.assertEquals(carList.size(),3);
         Assert.assertEquals(carList.get(0).getBrand(),porshe.getBrand());
         Assert.assertEquals(carList.get(1).getBrand(),mercedes.getBrand());
         Assert.assertEquals(carList.get(2).getBrand(),huindai.getBrand());
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(huindai);

        Car mostExpensivecar=garage.getTheMostExpensiveCar();
        Assert.assertEquals(mostExpensivecar.getBrand(),mercedes.getBrand());
    }

    @Test
    public void testFindAllCarsByBrnad(){
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(huindai);

        List<Car>carByBrand=garage.findAllCarsByBrand("Mercedes");

        Assert.assertEquals(carByBrand.size(),1);
        Assert.assertEquals(carByBrand.get(0).getBrand(),mercedes.getBrand());
    }
}