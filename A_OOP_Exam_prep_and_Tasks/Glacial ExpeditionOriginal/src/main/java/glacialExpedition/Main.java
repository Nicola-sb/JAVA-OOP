package glacialExpedition;

import glacialExpedition.core.Controller;
import glacialExpedition.core.ControllerImpl;
import glacialExpedition.core.Engine;
import glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
        // State state=new StateImpl("WestCoast");
        //        state.getExhibits().add("Banica");
        //        state.getExhibits().add("Manjdare");
        //        state.getExhibits().add("Airqqqnche");
        //
        //        Explorer explorer1=new NaturalExplorer("Pesho");
        //        Explorer explorer2=new GlacierExplorer("Gosho");
        //
        //        Collection<Explorer>explorers=new ArrayList<>();
        //
        //        explorers.add(explorer1);
        //        explorers.add(explorer2);
        //
        //        Mission mission=new MissionImpl();
        //        mission.explore(state,explorers);

        //  State state=new StateImpl("WestCoast");
        //        state.getExhibits().add("Banica");
        //        state.getExhibits().add("Manjdare");
        //        state.getExhibits().add("Airqqqnche");
        //
        //        Explorer explorer1=new NaturalExplorer("Pesho");
        //        Explorer explorer2=new GlacierExplorer("Gosho");
        //
        //        Collection<Explorer>explorers=new ArrayList<>();
        //
        //        explorers.add(explorer1);
        //        explorers.add(explorer2);
        //
        //        Mission mission=new MissionImpl();
        //        mission.explore(state,explorers);
    }
}
