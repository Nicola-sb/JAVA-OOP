package ValidationData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        firstTeam=new ArrayList<>();
        reserveTeam=new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //•	addPlayer(Person person): void
    //•	getFirstTeam(): List<Person> (Collections.unmodifiableList)
    //•	getReserveTeam(): List<Person> (Collections.unmodifiableList
    public void addPlayer(Person person){
        if(person.getAge() < 40){
            firstTeam.add(person);
        }else{
            reserveTeam.add(person);
        }
    }
    public List<Person>getFirstTeam(){
        return Collections.unmodifiableList(firstTeam);
    }
    public List<Person>getReserveTeam(){
        return Collections.unmodifiableList(reserveTeam);
    }
}
