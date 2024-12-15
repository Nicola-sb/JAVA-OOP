package Reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        Class clazz=Reflection.class;

        Method[] methods= clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") && method.getParameterCount()==0).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s will return %s%n",method.getName(),method.getReturnType()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set") && method.getParameterCount()==1).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s will return %s%n",method.getName(),method.getParameterTypes()[0].getName()));




//        Reflection reflection=new Reflection();
//        System.out.println(reflection);

    }
}
