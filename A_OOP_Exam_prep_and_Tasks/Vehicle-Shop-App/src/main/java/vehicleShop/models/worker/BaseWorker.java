package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker{

    private String name;
    private int strength;
    private Collection<Tool>tools;

    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools=new ArrayList<>();
    }


    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(int strength) {
        if(strength < 0){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    @Override
    public void working() {
        //The working() method decreases workers' strength by 10.
        //•	A worker's strength should not drop below 0 (If the strength becomes less than 0, set it to 0).
        setStrength(Math.max(0,getStrength()-10));
    }

    @Override
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return strength>0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }

    @Override
    public String toString() {
                long countFitTools = this.getTools().stream().filter(t -> t.getPower()>0).count();
                StringBuilder output = new StringBuilder();
                output.append(String.format("Name: %s, Strength: %d", this.name, this.strength)).append(System.lineSeparator());
                output.append(String.format("Tools: %d fit left", countFitTools)).append(System.lineSeparator());
                return output.toString().trim();
    }
}
