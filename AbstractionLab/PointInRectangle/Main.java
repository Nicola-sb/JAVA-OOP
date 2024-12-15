package AbstractionLab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] coordinates= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bottomLeftX=coordinates[0];
        int bottomLeftY=coordinates[1];
        int torRightX=coordinates[2];
        int torRightY=coordinates[3];

        Point bottomLeft=new Point(bottomLeftX,bottomLeftY);//долу ляво
        Point topRight=new Point(torRightX,torRightY);//горе в дясно

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int countPoints=Integer.parseInt(scanner.nextLine());//общ брой на проверени точки

        for(int i=1 ;i<=countPoints ;i++){
            int [] checkPointCoordinates=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = checkPointCoordinates[0];
            int y = checkPointCoordinates[1];

            Point searchPoint = new Point(x,y);

            System.out.println(rectangle.contains(searchPoint));
        }




    }
}
