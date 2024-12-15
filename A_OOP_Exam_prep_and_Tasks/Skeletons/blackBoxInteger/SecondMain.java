package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Scanner scanner = new Scanner(System.in);


        String input=scanner.nextLine();
        Class<BlackBoxInt>clazz=BlackBoxInt.class;
        Constructor<BlackBoxInt>constructor=clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt=constructor.newInstance();

        Field innerValue= clazz.getDeclaredField("innerValue");

        List<Method>methods= Arrays.asList(clazz.getDeclaredMethods());

        while (!input.equals("END")){
            String command=input.split("_")[0];
            int number=Integer.parseInt(input.split("_")[1]);

            switch (command){
                case "add":
                    Method add=clazz.getMethod("add");
//                    Method add= clazz.getDeclaredMethod("add");
                    add.setAccessible(true);
                    add.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "subtract":
                    Method subtract= clazz.getDeclaredMethod("subtract");
                    subtract.setAccessible(true);
                    subtract.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "divide":
                    Method divide= clazz.getDeclaredMethod("divide");
                    divide.setAccessible(true);
                    divide.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "multiply":
                    Method multiply= clazz.getDeclaredMethod("multiply");
                    multiply.setAccessible(true);
                    multiply.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "rightShift":
                    Method rightShift= clazz.getDeclaredMethod("rightShift");
                    rightShift.setAccessible(true);
                    rightShift.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
                case "leftShift":
                    Method leftShift= clazz.getDeclaredMethod("leftShift");
                    leftShift.setAccessible(true);
                    leftShift.invoke(blackBoxInt,number);
                    System.out.println(innerValue.get(blackBoxInt));
                    break;
            }

            input=scanner.nextLine();
        }
    }
}
