package AbstractionLab;

public class Calculate {
    public static int printCub(int x){
        return x*x*x;
    }

    public static void main(String[] args) {

        int result=Calculate.printCub(5);
        System.out.println(result);
        result=Calculate.printCub(4);
        System.out.println(result);
    }
}
