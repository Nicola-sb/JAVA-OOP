package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private FootballTeam footballTeam;
    private Footballer defanceFootballer;
    private Footballer forward;

    @Before
    public void setup(){
        footballTeam=new FootballTeam("Liverpool",4);
        defanceFootballer=new Footballer("Dajk");
        forward=new Footballer("Salah");
    }
    @Test(expected = NullPointerException.class)
    public void testFootballTeamInvalidName(){
        FootballTeam footballTeam1=new FootballTeam("",4);
    }
    @Test(expected = NullPointerException.class)
    public void testFootballTeamNullName(){
        FootballTeam footballTeam1=new FootballTeam(null,4);
    }
    @Test
    public void testCorrectFootbalTeam(){
        FootballTeam kazan=new FootballTeam("Kazan",12);
        Assert.assertEquals(kazan.getName(),"Kazan");
        Assert.assertEquals(kazan.getVacantPositions(),12);
        Assert.assertEquals(kazan.getCount(),0);
        kazan.addFootballer(defanceFootballer);
        Assert.assertEquals(kazan.getCount(),1);
    }
    @Test
    public void testAddFootballer(){
        Assert.assertEquals(0,footballTeam.getCount());
        footballTeam.addFootballer(defanceFootballer);
        Assert.assertEquals(1,footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerThrowsException(){
        FootballTeam  footballTeam1=new FootballTeam("Beroe",1);
        footballTeam1.addFootballer(defanceFootballer);
        footballTeam1.addFootballer(forward);
    }

    @Test
    public void testFootballerToSale(){
        footballTeam.addFootballer(defanceFootballer);
        footballTeam.addFootballer(forward);
        Footballer footballerToSale=footballTeam.footballerForSale("Dajk");
        Assert.assertEquals(footballerToSale.getName(),defanceFootballer.getName());
        Assert.assertFalse(footballerToSale.isActive());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballerThrowsException(){
        Footballer footballerToSale=footballTeam.footballerForSale(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExcpetionInvalidVacationPosition(){
        FootballTeam footballTeam1=new FootballTeam("beroe",-4);
    }

    @Test
    public void testRemoveFootballer(){
        footballTeam.addFootballer(defanceFootballer);
        footballTeam.addFootballer(forward);
        Assert.assertEquals(2,footballTeam.getCount());
        footballTeam.removeFootballer(defanceFootballer.getName());
        Assert.assertEquals(1,footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrowsExcpetion(){
        footballTeam.removeFootballer(null);
    }
    @Test
    public void testGetStatistics(){
        footballTeam.addFootballer(defanceFootballer);
        Assert.assertEquals("The footballer Dajk is in the team Liverpool.",footballTeam.getStatistics());
    }
}
