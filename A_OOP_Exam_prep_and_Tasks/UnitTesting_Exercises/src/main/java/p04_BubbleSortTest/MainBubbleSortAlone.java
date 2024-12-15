package p04_BubbleSortTest;

public class MainBubbleSortAlone {


    public static void sortBubble(int[]arrayBubble){
        int n= arrayBubble.length;


        for(int i=0 ;i<n ;i++){
            for(int j=0 ;j<n-i ;j++){
                if(arrayBubble[j]>arrayBubble[j+1]){
                    int temp=arrayBubble[j];
                    arrayBubble[j]=arrayBubble[j+1];
                    arrayBubble[j+1]=temp;
                }
            }
        }
    }


}
