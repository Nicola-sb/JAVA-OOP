package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer{

    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum=new BaseMuseum();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    @Override
    public void dig() {
        //•	The method decreases the discoverer's energy by 15 units.
        //•	The energy value should not drop below zero.
        //•	Set the value to be zero if the energy value goes below zero
        energy=Math.max(0,energy-15);
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb=new StringBuilder();
//        if(getMuseum().getExhibits().isEmpty()){
//            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None")).append(System.lineSeparator());
//        }else{
//            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
//                    String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,getMuseum().getExhibits())));
//        }
//    }
}
