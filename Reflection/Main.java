package Reflection;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

@Subject(categories = {"Reflection","Annotation"})

@Test(resposible = {"Nicola","Pesho"})
public class Main {

    String name="Nicola";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {



        Class clazz=Reflection.class;

        Method[] methods= clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") && method.getParameterCount()==0).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s will return class %s%n",method.getName(),method.getReturnType()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set") && method.getParameterCount()==1).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s and will set field of class %s%n",method.getName(),method.getParameterTypes()[0].getName()));

        Class a=Reflection.class;
        Annotation[] annotations = a.getAnnotations();
        System.out.println();


//        Reflection reflection=new Reflection();
//        System.out.println(reflection);

    }
}
