package MilitaryElite;

import java.util.Collection;

public interface Commando extends Soldier{

    	public void addMission(Mission mission);
    	public Collection<Mission> getMissions();

}
