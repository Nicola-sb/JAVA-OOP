package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverRepository implements Repository<Driver> {

    private Map<String,Driver>driverMap;

    public DriverRepository() {
        driverMap=new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return driverMap.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(driverMap.values());
    }

    @Override
    public void add(Driver driver) {
         driverMap.put(driver.getName(),driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return driverMap.remove(driver.getName())!=null;
    }
}
