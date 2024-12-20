package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            String unitType=getData()[1];
            getRepository().removeUnit(getData()[1]);
            return String.format("%s retired!",unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
}
