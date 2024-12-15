package blackBoxInteger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourMain {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);



        String input=scanner.nextLine();
        Class<BlackBoxInt>clazz=BlackBoxInt.class;
        Constructor<BlackBoxInt>constructor= clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt= constructor.newInstance();

        Field innerValue=clazz.getDeclaredField("innerValue");

        List<Method>methods= Arrays.asList(clazz.getDeclaredMethods());
        while (!input.equals("END")){
            String command=input.split("_")[0];
            int number=Integer.parseInt(input.split("_")[1]);

            switch (command){
                case "add":
                    extracted(blackBoxInt, innerValue, methods, command, number);
                    break;
                case "subtract":
                    extracted(blackBoxInt,innerValue,methods,command,number);
                    break;
                case "divide":
                    extracted(blackBoxInt,innerValue,methods,command,number);
                    break;
                case "multiply":
                    extracted(blackBoxInt,innerValue,methods,command,number);
                    break;
                case "rightShift":
                    extracted(blackBoxInt,innerValue,methods,command,number);
                    break;
                case "leftShift":
                    extracted(blackBoxInt,innerValue,methods,command,number);
                    break;
            }
            input=scanner.nextLine();
        }
    }

    private static void extracted(BlackBoxInt blackBoxInt, Field innerValue, List<Method> methods, String command, int number) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods) {
            if(method.getName().equals(command)){
                method.setAccessible(true);
                method.invoke(blackBoxInt, number);
                innerValue.setAccessible(true);
//                System.out.println(innerValue.get(blackBoxInt));
                System.out.println(innerValue.get(blackBoxInt));
                break;
            }
        }
    }
}
