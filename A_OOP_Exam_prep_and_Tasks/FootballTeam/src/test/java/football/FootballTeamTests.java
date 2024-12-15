package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test(expected = IllegalArgumentException.class)
    public void testVacantionPositonThrowsException(){
        FootballTeam footballTeam=new FootballTeam("Kazan",-4);
    }
    @Test(expected = NullPointerException.class)
    public void testNameThrowsNullPointException(){
        FootballTeam footballTeam=new FootballTeam(null,4);
    }
    @Test(expected = NullPointerException.class)
    public void testNameThrowsNullPointExceptionEmptyName(){
        FootballTeam footballTeam=new FootballTeam("",4);
    }
    // метода адд
    //1.Успешно добавен футболист
    //2.Ако нямам място да добавя футболиста
    @Test
    public void testAddCorrectFootballer(){
        FootballTeam footballTeam=new FootballTeam("Kazan",11);
        Footballer footballer=new Footballer("Mladiq");
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1,footballTeam.getCount());
        Assert.assertEquals(11,footballTeam.getVacantPositions());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFootollerThrowsException(){
        FootballTeam footballTeam=new FootballTeam("Kazan",1);
        Footballer footballer=new Footballer("Mladiq");
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1,footballTeam.getCount());
        Footballer footballer1=new Footballer("MladiqJR");
        footballTeam.addFootballer(footballer1);
    }
    @Test
    public void testRemoveFootballer(){
        FootballTeam footballTeam=new FootballTeam("Kazan",1);
        Footballer footballer=new Footballer("Mladiq");
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1,footballTeam.getCount());
        footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(0,footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrowsException(){
        FootballTeam footballTeam=new FootballTeam("Kazan",1);
        Footballer footballer=new Footballer(null);
        footballTeam.removeFootballer(footballer.getName());
    }
    @Test
    public void testFootballerForSale(){
        FootballTeam footballTeam=new FootballTeam("Kazan",11);
        Footballer footballer=new Footballer("Mladiq");
        footballTeam.addFootballer(footballer);
        Footballer footballerForSale=footballTeam.footballerForSale(footballer.getName());
        Assert.assertFalse(footballer.isActive());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootbaleerForSaleThrowsException(){
        FootballTeam footballTeam=new FootballTeam("Kazan",11);
        Footballer footballer=new Footballer(null);
        footballTeam.footballerForSale("dasa");
    }
    @Test
    public void testGetStatistics(){
        FootballTeam footballTeam=new FootballTeam("Kazan",11);
        Footballer footballer=new Footballer("Mladiq");
        Footballer footballer1=new Footballer("KrisiJR");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer1);
        Assert.assertEquals("The footballer Mladiq, KrisiJR is in the team Kazan.",footballTeam.getStatistics());
    }
}
