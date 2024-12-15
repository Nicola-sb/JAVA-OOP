package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer{

    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase=new Carton();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
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
    public void search(){
        this.energy=energy - 15;
//        if(energy<0){
//            this.energy=0;
//        }
        energy=Math.max(0,energy-15);
    }
    @Override
    public boolean canSearch(){
        return energy > 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME,getName())).append(System.lineSeparator());
        stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY,getEnergy())).append(System.lineSeparator());
        if(getSuitcase().getExhibits().isEmpty()){
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,"None"));
        }else{
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
            String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,getSuitcase().getExhibits())));
        }
           return stringBuilder.toString().trim();
    }
}
