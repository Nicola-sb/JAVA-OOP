package FootballTeamGenerator;

public class Player {
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
    //-	setName(String) : void
    //+	getName(): String
    //-	setEndurance (int) : void
    //-	setSprint (int) : void
    //-	setDribble (int) : void
    //-	setPassing (int) : void
    //-	setShooting (int) : void
    //+	overallSkillLevel() : double

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        getRang(endurance,"Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        getRang(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        getRang(dribble,"Driblle");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        getRang(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        getRang(shooting,"Shooting");
        this.shooting = shooting;
    }
    //+	overallSkillLevel() : double
    public double overallSkillLevel(){
        return (endurance + sprint + dribble + passing + shooting) / 5.0;

    }
    //A player has a name and stats which are the basis for his skill level.
    // The stats a player has are endurance, sprint, dribble, passing, and shooting.
    // Each stat can be in the range [0..100].
    //•	Stats should be in the range [0..100]. If not, print: "{Stat name} should be between 0 and 100."
    public void getRang(int stats,String name){
        if(stats<0 || stats>100){
            String exceptionStats=String.format("%s should be between 0 and 100.",name);
            throw new IllegalArgumentException(exceptionStats);
        }
    }
}
