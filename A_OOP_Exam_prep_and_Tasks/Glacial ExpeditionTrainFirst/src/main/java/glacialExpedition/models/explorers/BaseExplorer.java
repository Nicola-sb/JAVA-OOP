package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public void setSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
    }

    @Override
    public void search() {
        //•	The method decreases the explorer's energy by 15 units.
        //•	The energy value should not drop below zero.
        //•	Set the value to be zero if the energy value goes below zero.
//        setEnergy(Math.max(0,energy=energy-15));
        energy=Math.max(0,energy-15);
    }

    @Override
    public boolean canSearch() {
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
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME,getName())).append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY,getEnergy())).append(System.lineSeparator());
        //Трявба да проверя дали има ескпонати или няма; Ако няма хвърлям ексепшън
        if(getSuitcase().getExhibits().isEmpty()){
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,"None"));
        }else{
            //Ако имам експонати трябва да ги изброя с ", " //DELIMITER
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                    String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,getSuitcase().getExhibits())));
        }

        return sb.toString();
    }
}
