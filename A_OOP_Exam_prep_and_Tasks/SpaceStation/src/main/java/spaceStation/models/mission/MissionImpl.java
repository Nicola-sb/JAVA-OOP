package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MissionImpl implements Mission{


    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
//•	The astronauts start going out into open space one by one. They can't go if they don't have any oxygen left.
//        //•	An astronaut lands on a planet and starts collecting its items one by one.
//        //•	He finds an item and he takes a breath.
//        //•	He adds the item to his backpack and respectively the item must be removed from the planet.
//        //•	Astronauts can't keep collecting items if their oxygen becomes 0.
//        //•	If it becomes 0, the next astronaut starts exploring.
        for(int i=0 ;i<astronauts.size() ;i++){
            Astronaut currentAstronaut=astronauts.get(i);
            for(int j=0 ;j<planet.getItems().size() ;j++){
                String currentItem=planet.getItems().get(j);
                currentAstronaut.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                currentAstronaut.breath();
                j--;

                if(!currentAstronaut.canBreath()){
                    astronauts.remove(currentAstronaut);
                    i--;
                    break;

                }

            }
//        for (Astronaut currentAstronaut : astronauts) {
//            for (String item : planet.getItems()) {
//                currentAstronaut.breath();
//                currentAstronaut.getBag().getItems().add(item);
//                planet.getItems().remove(item);
//                if(!currentAstronaut.canBreath()){
//                    astronauts.remove(currentAstronaut);
//                    break;
//                }
//            }
        }
    }




//    @Override
//    public void explore(Planet planet, Collection<Astronaut> astronauts) {
//        //•	The astronauts start going out into open space one by one. They can't go if they don't have any oxygen left.
//        //•	An astronaut lands on a planet and starts collecting its items one by one.
//        //•	He finds an item and he takes a breath.
//        //•	He adds the item to his backpack and respectively the item must be removed from the planet.
//        //•	Astronauts can't keep collecting items if their oxygen becomes 0.
//        //•	If it becomes 0, the next astronaut starts exploring.
//        Collection<String> planetItems=planet.getItems();//Тука си държа на планената предметите
//        for (Astronaut currentAsrtrounaut : astronauts) {
//            if(currentAsrtrounaut.canBreath() && planetItems.iterator().hasNext()){
//                currentAsrtrounaut.breath();
//                String currentItem=planetItems.iterator().next();
//                currentAsrtrounaut.getBag().getItems().add(currentItem);
//                planetItems.remove(currentItem);
//            }
//        }
//    }
}
