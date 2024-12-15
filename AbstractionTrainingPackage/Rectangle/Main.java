package AbstractionTrainingPackage.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int []coordinates= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int bottomLeftX=coordinates[0];
      int bottomleftY=coordinates[1];
      int topRightX=coordinates[2];
      int topRightY=coordinates[3];

      Point bottomLeft=new Point(bottomLeftX,bottomleftY);
      Point topRight=new Point(topRightX,topRightY);
      Rectangle rectangle=new Rectangle(bottomLeft,topRight);

      int n=Integer.parseInt(scanner.nextLine());

        searchedMethod(scanner, rectangle, n);
    }

    private static void searchedMethod(Scanner scanner, Rectangle rectangle, int n) {
        for(int i = 1; i<= n; i++){
            int []coordinatesPoint=Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int firstPoint=coordinatesPoint[0];
            int secondPoint=coordinatesPoint[1];
            Point point=new Point(firstPoint,secondPoint);

            System.out.println(rectangle.contains(point));
        }
    }
}
