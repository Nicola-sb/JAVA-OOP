package AbstractionLab;

public class CounterClass {

    int count=0;
    static int staticCount=0;

    public CounterClass(){
       count++;
       staticCount++;
    }
    public void printCounters(){
        System.out.printf("Count: %d%n",count);
        System.out.printf("Static count: %d%n",staticCount);
    }
}
