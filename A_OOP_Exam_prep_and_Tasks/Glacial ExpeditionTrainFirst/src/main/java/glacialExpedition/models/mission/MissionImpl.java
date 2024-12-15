package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayList<String>statesExhibits=new ArrayList<>(state.getExhibits());

        for (Explorer currentExplorer : explorers) {
            while (currentExplorer.canSearch() && !statesExhibits.isEmpty()){
                currentExplorer.search();
                String currentExhibit=statesExhibits.get(0);
                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
                statesExhibits.remove(0);
            }
        }
    }


//    @Override
//    public void explore(State state, Collection<Explorer> explorers) {
////•	Explorers cannot go on expeditions if their energy is below 0.
////•	They leave the station and start collecting exhibits one by one.
////•	If they find an exhibit, their energy is decreased.
////•	They add the exhibit to their carton. The exhibit should then be removed from the state.
////•	Explorers cannot continue collecting exhibits if their energy drops to 0.
////o	If their energy drops to 0, the next explorer starts exploring.
//        //1.Ако енергията на изследователя е < 0 не може да отиде да изследва
//        //Ако намери експонат,неговата енергия се намаля
//        //Трябва да се добави експоната към неговия Картон.След това експоната трябва да бъде премахнат
//        //Ако енергията на изследователя падне под 0,трябва да започна със следващия изследовател
//
//        //1.Трябва да си взема изследователите
//        Collection<String>stateExibits=state.getExhibits();//Така си взимам всичките експонати
////        ArrayList<String>stateExhibits=new ArrayList<>(state.getExhibits());
//        for (Explorer currentExplorer : explorers) {
//            while (currentExplorer.canSearch() && stateExibits.iterator().hasNext()){
//                currentExplorer.search();
//                String currentExhibit=stateExibits.iterator().next();
//                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);//state.getExhibits().add(currentExhibit);
//                stateExibits.remove(currentExhibit);
//            }
//        }
//    }
}
