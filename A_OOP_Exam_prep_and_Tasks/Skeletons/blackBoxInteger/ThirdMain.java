package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThirdMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);


        String input=scanner.nextLine();
        Class<BlackBoxInt>clazz=BlackBoxInt.class;
        Constructor<BlackBoxInt>constructor=clazz.getDeclaredConstructor();
        constructor.setAccessible(true);//правя конструктора достъпен
        //За да мога чрез този констуктор да създам обект,той трябва да бъде достъпен
        BlackBoxInt blackBoxInt=constructor.newInstance();

        Field innerValue= clazz.getDeclaredField("innerValue");
        List<Method>methods= Arrays.asList(clazz.getDeclaredMethods());
        while (!input.equals("END")){
            String command=input.split("_")[0];
            int number=Integer.parseInt(input.split("_")[1]);

            switch (command){
                case "add":
                    //АКо имам командата add трябва да измикам метода add
//                    Method add = clazz.getDeclaredMethod("add");
//                    add.setAccessible(true);//правя си метода достъпен
//                    //След това методът add искам да ми се изпълни -->
//                    add.invoke(blackBoxInt,number);//Това е все едно казваме blackBoxInt.add(number);
//                            //Когато изпълнявам invoke трябва да кажем кой е обекта върху който искаме да изпълним този метод
//                    //и кой са аргументите който искам да подам на този метод
//                    System.out.println(innerValue); //трябва да си взема innerValue-->Field innerValue= clazz.getDeclaredField("innerValue");
                    //Искам да си взема полето innerValue от обекта blackBoxInt
                    //innerValue-текуща стойност
                    //След метода add всеки път трябва да принтираме стойността,която съхраняваме в кутията

                    extracted(clazz, blackBoxInt, innerValue, number,"add",methods);
                    break;
                case "subtract":
                    for (Method method : methods) {
                        if(method.getName().equals(command)){
                            method.setAccessible(true);
                            method.invoke(blackBoxInt,number);
                            innerValue.setAccessible(true);
                            System.out.println(innerValue.get(blackBoxInt));
                        }
                    }
//                    Method subtract=clazz.getDeclaredMethod("subtract");
//                    subtract.setAccessible(true);
//                    subtract.invoke(blackBoxInt,number);
//                    innerValue.setAccessible(true);
//                    System.out.println(innerValue.get(blackBoxInt));
                    break;

            }






            input=scanner.nextLine();
        }
    }

    private static void extracted(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxInt, Field innerValue, int number,String command,List<Method>methods) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentMethod=null;

        for (Method method : methods) {
            if(method.getName().equals(command)){
                currentMethod=method;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt, number);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
