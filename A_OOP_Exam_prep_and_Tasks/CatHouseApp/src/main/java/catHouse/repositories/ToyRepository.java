package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository{

    private Collection<Toy>toys;

    public ToyRepository() {
        this.toys=new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
      toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        //•	Removes a toy from the collection. Returns true if the deletion was successful, otherwise - false
        return toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        //Returns the first toy of the given type, if there is. Otherwise, returns null.
        return toys.stream().filter(toy -> toy.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
