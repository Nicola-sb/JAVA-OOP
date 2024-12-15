package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarRepository implements Repository<Car> {

    private Map<String,Car>carMap;

    public CarRepository() {
        carMap=new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return this.carMap.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(carMap.values());
    }

    @Override
    public void add(Car car) {
        this.carMap.put(car.getModel(),car);
    }

    @Override
    public boolean remove(Car car) {
        return carMap.remove(car.getModel())!=null;
//        if(carMap.containsKey(car.getModel())){
//            carMap.remove(car.getModel());
//            return true;
//        }
//        return false;
    }
}
