package StudentSystemAlone;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        String[] input=scanner.nextLine().split("//s+");
//        StudentSystem studentSystem=new StudentSystem();
////        List<Student>studentsList=new ArrayList<>();
//        Map<String,Student>studentMap=new LinkedHashMap<>();
//
//        while (!input[0].equals("Exit")){
////Create {studentName} {studentAge} {studentGrade}" – creates a new student and adds them to the repository.
////•	"Show {studentName}" – prints on the console information about a student in the format:
////"{studentName} is {studentAge} years old. {commentary}.", where the commentary is based on the student’s grade.
//            studentSystem.getInput(input);
//
//
//            input=scanner.nextLine().split(" ");
//        }
        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("Exit")) {

            studentSystem.getInput(input);
            input=scanner.nextLine().split(" ");
        }
    }
}
