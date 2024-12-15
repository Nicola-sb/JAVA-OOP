package TrainingPackageInterfaces;

public class Koala implements Animal{

    public String getFood(){
        return "grass";
    }

    @Override
    public void speak() {
        System.out.println("A'm a Koala");
    }


}
