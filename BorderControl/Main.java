package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Citizen>citizenList=new ArrayList<>();
//        List<Robot>robotList=new ArrayList<>();
//
//        String command=scanner.nextLine();
//        while (!command.equals("End")){
//            String[]infoCommand=command.split(" ");
//
//           if(infoCommand.length==3){
//               String name=infoCommand[0];
//               int age=Integer.parseInt(infoCommand[1]);
//               String id=infoCommand[2];
//               Citizen citizen=new Citizen(name,age,id);
//               citizenList.add(citizen);
//           }else if(infoCommand.length==2){
//               String model=infoCommand[0];
//               String id=infoCommand[1];
//               Robot robot=new Robot(id,model);
//               robotList.add(robot);
//           }
//
//            command=scanner.nextLine();
//        }
//
//
//       String fakeNumberOfIds=scanner.nextLine();
//
//        List<Citizen>printCitizen=new ArrayList<>();
//
//        for (Citizen citizen : citizenList) {
//            if(citizen.getId().endsWith(fakeNumberOfIds)){
//                printCitizen.add(citizen);
//            }
//        }
//
//        List<Robot>printRobot=new ArrayList<>();
//
//        for (Citizen citizen : printCitizen) {
//            System.out.println(citizen.getId());
//        }
//
//        for (Robot robot : robotList) {
//            if(robot.getId().endsWith(fakeNumberOfIds)){
//                printRobot.add(robot);
//            }
//        }
//        for (Robot robot : printRobot) {
//            System.out.println(robot.getId());
//        }

        String input=scanner.nextLine();
        List<Identifiable>identifiables=new ArrayList<>();

        while (!input.equals("End")){
            String []inputData=input.split(" ");

            Identifiable identifiable=inputData.length==2 ? new Robot(inputData[0],inputData[1]) : new Citizen(inputData
            [0],Integer.parseInt(inputData[1]),inputData[2]);

            identifiables.add(identifiable);

            input=scanner.nextLine();
        }

        String fakeId=scanner.nextLine();

        identifiables.stream()//Пускам си един потов по identifiables
                .map(Identifiable::getId)//След стрийма ми трябват само id , за това преобразувам всичките данни като Id-ta ( Така всичко става в Стрингове)
                .filter(iden -> iden.endsWith(fakeId))//филтрирам си id-ta които завървшат на fakeId и след това си ги принтирам
                .forEach(System.out::println);



    }
}
