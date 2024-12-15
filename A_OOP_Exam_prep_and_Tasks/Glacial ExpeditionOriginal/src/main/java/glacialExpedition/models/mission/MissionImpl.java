package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class MissionImpl implements Mission{


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        //Here is how the explore method works:
        //•	Explorers cannot go on expeditions if their energy is below 0.
        //•	They leave the station and start collecting exhibits one by one.
        //•	If they find an exhibit, their energy is decreased.
        //•	They add the exhibit to their carton. The exhibit should then be removed from the state.
        //•	Explorers cannot continue collecting exhibits if their energy drops to 0.
        //o	If their energy drops to 0, the next explorer starts exploring.

        Collection<String>stateExhibits=state.getExhibits();
        //Toва ще са всичките находки през които трябва да преминем
        for (Explorer currentExplorer : explorers) {
            while (currentExplorer.canSearch() && stateExhibits.iterator().hasNext()){
                currentExplorer.search();
                String currentExhibit=stateExhibits.iterator().next();
                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
                stateExhibits.remove(currentExhibit);
            }
        }



    }
}
