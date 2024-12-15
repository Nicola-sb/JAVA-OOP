package christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race{

    private String name;
    private int laps;
    private Collection<Driver>drivers;

    public static final int MINIMUM_DRIVERS_IN_RACE=3;


    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private void setName(String name){
        if(name==null || name.trim().length() < 5){
            String exceptionMessage=String.format(ExceptionMessages.INVALID_NAME,name,5);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.name=name;
    }

    private void setLaps(int laps){
        if(laps < 1){
            String exceptionMessage=String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS,1);
        }
        this.laps=laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        //•	If a Driver is null throw an IllegalArgumentException with a message "Driver cannot be null.".
        //•	If a Driver cannot participate in the Race (the Driver doesn't own a Car) throw an IllegalArgumentException with a message "Driver {driver name} could not participate in race.".
        //•	If the Driver already exists in the Race throw an IllegalArgumentException with a message:
        //"Driver {driver name} is already added in {race name} race.".
        if(driver==null){
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        }else if(!driver.getCanParticipate()){
            String exceptionMessage=String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE,driver.getName());
            throw new IllegalArgumentException(exceptionMessage);
        }else if(drivers.contains(driver)){
            String exceptionMessage=String.format(ExceptionMessages.DRIVER_ALREADY_ADDED,driver.getName(),name);
            throw new IllegalArgumentException(exceptionMessage);
        }
          this.drivers.add(driver);
    }
}
