package StudentSystemAlone;

import java.util.LinkedHashMap;
import java.util.Map;

public class StudentSystem {

    Map<String,Student>studentMap=new LinkedHashMap<>();

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public StudentSystem() {
        this.studentMap = new LinkedHashMap<>();
    }

    public void getInput(String[]input){
       StringBuilder builder=new StringBuilder();

       String command=input[0];
       String studentName=input[1];

       if(command.equals("Create")){
           int studentAge=Integer.parseInt(input[2]);
           double studentGrade=Double.parseDouble(input[3]);
           if(!studentMap.containsKey(studentName)){
               Student student=new Student(studentName,studentAge,studentGrade);
               studentMap.put(studentName,student);
           }
       }else if(command.equals("Show")){
           //Show {studentName}" – prints on the console information about a student in the format:
           //"{studentName} is {studentAge} years old. {commentary}.", where the commentary is
           if(studentMap.containsKey(studentName)){
               Student student = studentMap.get(studentName);
               builder.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

               if (student.getGrade() >= 5.00) {
                   builder.append(" Excellent student.");
               } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                   builder.append(" Average student.");
               } else {
                   builder.append(" Very nice person.");
               }
               System.out.println(builder.toString());
           }
       }
   }
}
