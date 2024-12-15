package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {



    @Test
    public void testBubbleSort(){
        int [] numbers = { 0,4,2,13,222,123};
        Bubble.sort(numbers);
        //Очавквам масива ми да се сортира и да изглежда по този начин ->
        int expcected[]={0,2,4,13,123,222};
        Assert.assertArrayEquals(expcected,numbers);
    }
}