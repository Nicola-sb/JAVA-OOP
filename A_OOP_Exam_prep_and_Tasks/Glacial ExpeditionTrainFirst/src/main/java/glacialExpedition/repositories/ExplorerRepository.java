package glacialExpedition.repositories;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.models.explorers.Explorer;

import java.util.*;

public class ExplorerRepository implements Repository<Explorer> {

    private Map<String,Explorer> explorerMap;
//    private Collection<Explorer>explorerCollection;

    public ExplorerRepository() {
        explorerMap=new LinkedHashMap<>();
//        explorerCollection=new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorerMap.values());
//        return Collections.unmodifiableCollection(explorerCollection);
    }

    @Override
    public void add(Explorer entity) {
           explorerMap.put(entity.getName(),entity);
//        explorerCollection.add(entity);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return explorerMap.remove(explorer.getName())!=null;
//        return explorerCollection.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        return explorerMap.get(name);
//        for (Explorer explorer : explorerCollection) {
//            if(explorer.getName().equals(name)){
//                return explorer;
//            }
//        }
//        return null;
    }

    @Override
    public String toString() {
        //В класа ExploreRepository си правя метод тоСтринг,който да ми преминава през всички изследователи и да ги принтира
        //Съответно всеки един изследовател ще има метод тоСтринг и там вече ще се държи информацията за дадения изследовател
        StringBuilder sb=new StringBuilder();
        explorerMap.values().forEach(explorer -> sb.append(explorer).append(System.lineSeparator()));
//        for (Explorer currentExplorer : explorerMap.values()) {
//            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME,currentExplorer.getName()));
//            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY,currentExplorer.getEnergy()));
//            if(currentExplorer.getSuitcase().getExhibits().isEmpty()){
//                sb.append("None");
//            }
//            sb.append(currentExplorer.getSuitcase().getExhibits()).append(System.lineSeparator());
//
//        }
        return sb.toString();
    }
}
