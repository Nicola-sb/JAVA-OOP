package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
//Has initial kilograms of 7.
//Can only live in SecondaryService!
//The constructor should take the following values upon initialization:
//(String name, String kind, double price)
//Behavior
//void еating()
//•	The method increases the robot’s kilograms by 1.
    private static final int INITIAL_KILOGRAMS_FEMALE_ROBOT=7;


    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS_FEMALE_ROBOT, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
