package MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    private List<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, Corps corps) {
        super(id, firstName, lastName, corps);
        this.repairs=new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
       this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
