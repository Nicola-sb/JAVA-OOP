package robotService.repositories;

import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository{

    private Collection<Supplement>supplements;

    public SupplementRepository() {
        supplements=new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findFirst(String type) {
        //•	Returns the first supplement of the given type, if there is any. Otherwise, returns null
        return supplements.stream().filter( supplement -> supplement.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
