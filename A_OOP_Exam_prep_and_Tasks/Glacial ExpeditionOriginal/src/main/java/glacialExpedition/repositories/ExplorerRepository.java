package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer> {

    private Map<String,Explorer>explorerMap;

    public ExplorerRepository() {
        explorerMap=new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorerMap.values());
    }

    @Override
    public void add(Explorer entity) {
        //•	Adds an explorer to the station.
        //•	Every explorer is unique in the collection.
        //o	It is guaranteed that there will not be an explorer with the same name
        explorerMap.put(entity.getName(),entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorerMap.remove(entity.getName())!=null;
    }

    @Override
    public Explorer byName(String name) {
        return explorerMap.get(name);
    }

    @Override
    public String toString() {
         StringBuilder sb=new StringBuilder();
         explorerMap.values().forEach(explorer -> sb.append(explorer).append(System.lineSeparator()));
         return sb.toString().trim();
    }
}
