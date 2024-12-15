package FootballTeamGeneratorAlone;

public class Player {
    //name: String
    //endurance:  int
    //sprint:  int
    //dribble: int
    //passing: int
    //shooting: int
    //Player (String, int, int, int, int, int)
    //setName(String) : void
    //getName(): String
    //setEndurance (int) : void
    //setSprint (int) : void
    //setDribble (int) : void
    //setPassing (int) : void
    //setShooting (int) : void
    //overallSkillLevel() : double
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
       getStats(endurance,"Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        getStats(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        getStats(dribble,"Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        getStats(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        getStats(shooting,"Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }
    public double overallSkillLevel(){
        return (endurance+sprint+dribble+passing+shooting) / 5.0;
    }
    private void getStats(int stats,String name){
        if(stats<0 || stats>100){
            throw new IllegalArgumentException(name+" should be between 0 and 100.");
        }
    }
}
