package TrafficLightsAlone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String []signals=scanner.nextLine().split("\\s+");
        int n=Integer.parseInt(scanner.nextLine());

        List<TrafficLight>trafficLights=new ArrayList<>();

        for (String signal : signals) {
            Color color=Color.valueOf(signal);
            TrafficLight trafficLight=new TrafficLight(color);
            trafficLights.add(trafficLight);
        }


        for(int i=0 ;i<n ;i++){
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor()+ " ");
            }
            System.out.println();
        }
    }
}
