package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State>{

    private Map<String,State>stateMap;

    public StateRepository() {
        this.stateMap=new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(stateMap.values());
    }

    @Override
    public void add(State entity) {
        stateMap.put(entity.getName(),entity);
    }

    @Override
    public boolean remove(State entity) {
        return stateMap.remove(entity.getName())!=null;
    }

    @Override
    public State byName(String name) {
        //•	Returns a state with that name.
        //•	If the state is not in the collection, return null
        return stateMap.get(name);
    }
}
