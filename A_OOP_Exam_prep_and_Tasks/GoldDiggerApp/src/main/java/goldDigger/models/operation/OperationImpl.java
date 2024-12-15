package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.List;

public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        //•Discoverers cannot go on expeditions if their energy is below 0.
        //•	They leave the base and start collecting exhibits one by one.
        //•	If they find an exhibit, their energy is decreased.
        //•	They add the exhibit to their museum. The exhibit should then be removed from the state.
        //•	Discoverers cannot continue collecting exhibits if their energy drops to 0.
        //o	If their energy drops to 0, the next discoverer starts inspecting.
        Collection<String>spotCollection=spot.getExhibits();//Така си взимам всичите ескпонати

        for (Discoverer currentDiscoverer : discoverers) {
            while (currentDiscoverer.canDig() && spotCollection.iterator().hasNext()){
                currentDiscoverer.dig();
                String currentExhibit=spotCollection.iterator().next();
                currentDiscoverer.getMuseum().getExhibits().add(currentExhibit);
                spotCollection.remove(currentExhibit);
            }
        }
    }
}
