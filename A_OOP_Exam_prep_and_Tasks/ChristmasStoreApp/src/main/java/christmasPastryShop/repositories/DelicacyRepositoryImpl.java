package christmasPastryShop.repositories;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies=new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return delicacies.stream().filter(del -> del.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return delicacies;
    }

    @Override
    public void add(Delicacy delicacy) {
           delicacies.add(delicacy);
    }
}
