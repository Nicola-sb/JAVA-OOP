package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VehicleRepository implements Repository<Vehicle> {

    private Collection<Vehicle>vehicles;

    public VehicleRepository() {
        vehicles=new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    @Override
    public void add(Vehicle model) {
       vehicles.add(model);
    }

    @Override
    public boolean remove(Vehicle model) {
        return vehicles.remove(model);
    }

    @Override
    public Vehicle findByName(String name) {
        return vehicles.stream().filter(vehicle -> vehicle.getName().equals(name)).findFirst().orElse(null);
    }
}
