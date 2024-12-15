package MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{

    private List<Mission>missions;

    public CommandoImpl(int id, String firstName, String lastName, Corps corps) {
        super(id, firstName, lastName, corps);
        missions=new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
         missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }
}
