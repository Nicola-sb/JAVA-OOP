package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseService implements Service{

    private String name;
    private int capacity;
    //•	supplements - Collection<Supplement>
    //•	robots - Collection<Robot>
    private Collection<Supplement>supplements;
    private Collection<Robot>robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        supplements=new ArrayList<>();
        robots=new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    public void setRobots(Collection<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addRobot(Robot robot) {
        //Adds a Robot in the Service if there is a capacity for it.
        //If there is not enough capacity to add the Robot in the Service, throw an IllegalStateException with the following message:
        //•	"Not enough capacity for this robot."
        if(capacity<robots.size()){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        robots.add(robot);

    }

    @Override
    public void removeRobot(Robot robot) {
         robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
      //Adds a Supplements in the Service
        supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness(){
        return supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {
        //Returns a String with information about the Service in the format below.
        //"{serviceName} {serviceType}:
        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        //Note: I remind you that there are two service types – MainService and SecondaryService.
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%s %s:",name,this.getClass().getSimpleName())).append(System.lineSeparator());
        if(robots.isEmpty()){
            sb.append("Robots: none");
        }else{
            List<Robot>robotList=new ArrayList<>(robots);

            List<String>robotsList=new ArrayList<>();
            for (Robot robot : robotList) {
                robotsList.add(robot.getName());
            }
            sb.append(String.format("Robots: %s",String.join(" ",robotsList))).append(System.lineSeparator());
        }
        sb.append(String.format("Supplements: %d Hardness: %d",supplements.size(),sumHardness()));
        return sb.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }
}
