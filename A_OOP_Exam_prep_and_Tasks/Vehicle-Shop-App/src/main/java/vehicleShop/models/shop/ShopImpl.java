package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop{


    @Override
    public void make(Vehicle vehicle, Worker worker) {
        //•	The worker starts making the vehicle. This is only possible if the worker has strength and a tool that isn't broken.
        //•	Keep working until the vehicle is done or the worker has strength (and tools to use).
        //•	If at some point the power of the current tool reaches or drops below 0,
        // meaning it is broken, then the worker should take the next tool from its collection, if it has any left.

        //Взимам си работника и започвам да работя по колата -> Мога само ако работника има сила и инструмент
        //Работника продължава да работи,докато автомобила не е готов или докато има сила(и инструменти,който да използва)
        //Ако в даден момент инструмента на работника се счупи,той трябва да вземе следващия,ако има такъв
        Collection<Tool>currentWorkerTools=worker.getTools();//Така взимам инструментите на работника
        while (worker.canWork() && currentWorkerTools.iterator().hasNext() && !vehicle.reached()){//Докато работни може да работи и има следващ инструмент
            Tool currentTool=currentWorkerTools.iterator().next();
            currentTool.decreasesPower();
            worker.working();
            vehicle.making();
                 if(currentTool.isUnfit()){
                       currentTool=currentWorkerTools.iterator().next();
                 }
        }

//
//        while (!vehicle.reached() && currentWorkerTools.iterator().hasNext()){
//            worker.canWork();
//            currentWorkerTools.iterator().next();
//
//        }




    }
}
