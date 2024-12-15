package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth>booths;

    public BoothRepositoryImpl() {
        this.booths=new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return booths.stream().filter(n -> n.getBoothNumber() == number).findFirst().orElse(null);
        //!!!!!!!!!!!!!!!!!!!!!!
        //Booth booth = booths.stream().filter(t -> t.getBoothNumber() == number).findFirst().orElse(null);
        //        return booth;
    }

    @Override
    public Collection<Booth> getAll() {
        return booths;
    }

    @Override
    public void add(Booth booth) {
           booths.add(booth);
    }
}
