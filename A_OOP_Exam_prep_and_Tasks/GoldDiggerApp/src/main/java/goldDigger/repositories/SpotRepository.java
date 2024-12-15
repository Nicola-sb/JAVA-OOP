package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot>{

    private Collection<Spot>spotCollection;

    public SpotRepository() {
        spotCollection=new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spotCollection);
    }

    @Override
    public void add(Spot entity) {
            spotCollection.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return spotCollection.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        for (Spot spot : spotCollection) {
            if(spot.getName().equals(name)){
                return spot;
            }
        }
        return null;
    }

    public Collection<Spot> getSpotCollection() {
        return spotCollection;
    }

    public void setSpotCollection(Collection<Spot> spotCollection) {
        this.spotCollection = spotCollection;
    }
}
