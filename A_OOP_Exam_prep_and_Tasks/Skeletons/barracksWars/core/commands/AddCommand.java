package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command{
    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType=getData()[1];//Взимам си вида на бойната единициа
        Unit unitToAdd=this.getUnitFactory().createUnit(unitType);//След това я създаваме с помощта на Фабриката
        this.getRepository().addUnit(unitToAdd);//Към хранилището си добавям новия Unit
        String output=unitType + "added!";
        return output;
    }


    //private String addUnitCommand(String[] data) {
    //		String unitType = data[1];
    //		Unit unitToAdd = this.unitFactory.createUnit(unitType);
    //			this.repository.addUnit(unitToAdd);
    //		String output = unitType + " added!";
    //		return output;
    //	}
}
