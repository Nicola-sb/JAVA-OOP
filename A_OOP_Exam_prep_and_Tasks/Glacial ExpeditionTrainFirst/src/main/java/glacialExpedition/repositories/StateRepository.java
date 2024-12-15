package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;

public class StateRepository implements Repository<State> {

    private Collection<State>stateCollection;

    public StateRepository() {
        stateCollection=new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(stateCollection);
    }

    @Override
    public void add(State entity) {
        stateCollection.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        return stateCollection.remove(entity);
    }

    @Override
    public State byName(String name) {
        for (State state : stateCollection) {
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
