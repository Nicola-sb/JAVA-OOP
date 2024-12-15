package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.COUNT_BROKEN_INSTRUMENTS;
import static vehicleShop.common.ConstantMessages.VEHICLE_DONE;

public class ControllerImpl implements Controller{

    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private int countReadyVehicle;

    public ControllerImpl() {
           workerRepository=new WorkerRepository();
           vehicleRepository=new VehicleRepository();
           countReadyVehicle=0;
    }

    @Override
    public String addWorker(String type, String workerName) {
        //Creates a worker with the given name of the given type.
        //If the worker is invalid (the type is not FirstShift or SecondShift), throw an IllegalArgumentException with the message:
        //"Worker type doesn't exist."
        //The method should return the following message if the worker has been added to the repository:
        //"Successfully added {workerType} with name {workerName}."
        Worker worker;
        switch (type){
            case "FirstShift":
                worker=new FirstShift(workerName);
                break;
            case "SecondShift":
                worker=new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);
        return String.format(ConstantMessages.ADDED_WORKER,type,workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        //Creates a vehicle with the provided name and required strength and adds it to the corresponding repository.
        //The method should return the following message:
        //•	"Successfully added Vehicle: {vehicleName}."
        Vehicle vehicle=new VehicleImpl(vehicleName,strengthRequired);
        vehicleRepository.add(vehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE,vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        //Creates a tool with the given power and adds it to the collection of the worker.
        //If the worker doesn't exist in the worker repository, throw an IllegalArgumentException with the message:
        //"The worker doesn't exist. You cannot add a tool."
        //The method should return the following message if the tool has been added to the worker:
        //"Successfully added tool with power {toolPower} to worker {workerName}."
        Worker worker=workerRepository.findByName(workerName);

        if(worker == null){
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }


        Tool tool=new ToolImpl(power);
        worker.addTool(tool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {

        List<Worker>workersAbove70Units=workerRepository.getWorkers().stream().filter(worker -> worker.getStrength() > 70).collect(Collectors.toList());

        if(workersAbove70Units.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        //Трябв да работят само работниците с над 70 юнитс
        //Тези които могат започват да работяв върхи дадената кола
        //Ако няма работници,които да могат да работят хврълям ексепшън
        Vehicle vehicle=vehicleRepository.findByName(vehicleName);

        Shop shop=new ShopImpl();
        long unshiftTools = 0;

        while (!workersAbove70Units.isEmpty() && !vehicle.reached()) {
            Worker currentWorker=workersAbove70Units.get(0);
            shop.make(vehicle,currentWorker);
            if(!currentWorker.canWork() || currentWorker.getTools().stream().noneMatch(tool -> tool.isUnfit())){
              unshiftTools=unshiftTools+currentWorker.getTools().stream().filter(Tool::isUnfit).count();
              workersAbove70Units.remove(currentWorker);
              break;
            }
            unshiftTools=unshiftTools+currentWorker.getTools().stream().filter(Tool::isUnfit).count();
        }

       String infoAboutVehicle="not done";
        if(vehicle.reached()){
            infoAboutVehicle="done";
            countReadyVehicle++;
        }

        StringBuilder sb=new StringBuilder();
        sb.append(String.format(VEHICLE_DONE, vehicleName, infoAboutVehicle));
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, unshiftTools));
        return sb.toString().trim();

    }

    @Override
    public String statistics() {
        //Returns information about making vehicles and workers:
        //"{countMadeVehicle} vehicles are ready!
        //Info for workers:
        //Name: {workerName1}, Strength: {workerStrength1}
        //Tools: {countTools} fit left"
        //…
        //"Name: {workerNameN}, Strength: {workerStrengthN}
        //Tools: {countTools} fit left"
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%d vehicles are ready!",countReadyVehicle)).append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        for (Worker currentWorker : workerRepository.getWorkers()) {
            sb.append(String.format("Name: %s, Strength: %d",currentWorker.getName(),currentWorker.getStrength())).append(System.lineSeparator());
            long fitToolsLeft=currentWorker.getTools().stream().filter(tool -> tool.getPower() > 0 ).count();
            sb.append(String.format("Tools: %d fit left",fitToolsLeft)).append(System.lineSeparator());
        }

//        workerRepository.getWorkers().stream().forEach(worker ->
//                sb.append(worker.toString()).append(System.lineSeparator()));
//        return sb.toString().trim();
        return sb.toString().trim();
    }
}
