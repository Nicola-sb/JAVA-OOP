package TrainingPackageInterfaces;

public class Lion implements Animal{

    public String getFood(){
        return "meat";
    }

    @Override
    public void speak() {
        System.out.println("A'm a Lion");
    }
}
