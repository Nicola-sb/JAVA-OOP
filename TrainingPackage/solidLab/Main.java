package TrainingPackage.solidLab;

public class Main {
    public static void main(String[] args) {

        FileReader reader=new FileReader();
        Writter writter=new ConsoleWritter();

        Copy copy=new Copy(reader,writter);
        copy.copyAll();
    }
}
