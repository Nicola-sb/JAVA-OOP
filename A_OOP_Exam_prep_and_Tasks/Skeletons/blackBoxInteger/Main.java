package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

         String input=scanner.nextLine();
         Class<BlackBoxInt>clazz=BlackBoxInt.class;
         Constructor<BlackBoxInt>constructor=clazz.getDeclaredConstructor();
         constructor.setAccessible(true);

         BlackBoxInt blackBoxInt= constructor.newInstance();

        Field innerValue= clazz.getDeclaredField("innerValue");

         List<Method>methods= Arrays.asList(clazz.getDeclaredMethods());

         while (!input.equals("END")){
             String command=input.split("_")[0];
             int number=Integer.parseInt(input.split("_")[1]);
             switch (command){
                 //add_999999
                 //subtract_19
                 //divide_4
                 //multiply_2
                 //rightShift_1
                 //leftShift_3
                 case "add":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"add",methods);
                     break;
                 case "subtract":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"subtract",methods);
                     break;
                 case "divide":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"divide",methods);
                     break;
                 case "multiply":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"multiply",methods);
                     break;
                 case "rightShift":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"rightShift",methods);
                     break;
                 case "leftShift":
                     extractedMethod(clazz, blackBoxInt, innerValue, number,"leftShift",methods);
                     break;
             }

             input=scanner.nextLine();
         }




    }

    private static void extractedMethod(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxInt, Field innerValue, int number,String command,List<Method>methods) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentMethod=null;

        for (Method method : methods) {
            if(method.getName().equals(command)){
                currentMethod=method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt,number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
