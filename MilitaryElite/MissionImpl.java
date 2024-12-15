package MilitaryElite;

public class MissionImpl implements Mission{

    @Override
    public void completeMission() {
        this.status=Status.FINISHED;
    }

    public enum Status{
        IN_PROGRESS,
        FINISHED
    }

    private String codeName;
    private Status status;

    public MissionImpl(String codeName, Status status) {
        this.codeName = codeName;
        this.status = status;
    }
}
