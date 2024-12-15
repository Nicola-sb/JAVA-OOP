package Logger;

import java.util.Scanner;

public class InputParser {

    public String readLineInput(Scanner scanner){
        StringBuilder builder=new StringBuilder();
        int n=Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            builder.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
