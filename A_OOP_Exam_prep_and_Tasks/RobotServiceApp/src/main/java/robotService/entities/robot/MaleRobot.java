package robotService.entities.robot;

public class MaleRobot extends BaseRobot{

    //Has initial kilograms of 9.
    //Can only live in MainService!
    //The constructor should take the following values upon initialization:
    //(String name, String kind, double price)
    //Behavior
    //void eating()
    //•	The method increases the robot’s kilograms by 3.
    private static final int INITIAL_KILOGRAMS_MALE_ROBOT=9;


    public MaleRobot(String name, String kind,double price) {
        super(name, kind, INITIAL_KILOGRAMS_MALE_ROBOT, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 3);
    }
}
