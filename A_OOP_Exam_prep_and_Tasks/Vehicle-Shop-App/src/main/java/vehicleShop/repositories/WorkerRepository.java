package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class WorkerRepository implements Repository<Worker>{
    private Collection<Worker>workers;

    public WorkerRepository() {
        workers=new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return workers;
    }

    @Override
    public void add(Worker model) {
       workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        return workers.remove(model);
    }

    @Override
    public Worker findByName(String name) {
        return workers.stream().filter(worker -> worker.getName().equals(name)).findFirst().orElse(null);
    }

    public void setWorkers(Collection<Worker> workers) {
        this.workers = workers;
    }

}
