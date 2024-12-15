package CollectionHieararchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection=new AddCollection();
        AddRemoveCollection addRemoveCollection=new AddRemoveCollection();
        MyListImpl myList=new MyListImpl();

//        String[] words=scanner.nextLine().split(" ");
        List<String> words= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int numberRemove=Integer.parseInt(scanner.nextLine());

        performAddOperation(words,addCollection);
        performAddOperation(words,addRemoveCollection);
        performAddOperation(words,myList);

        performRemoveOperation(numberRemove,addRemoveCollection);
        performRemoveOperation(numberRemove,myList);




    }
    public static void performAddOperation(List<String>words,Addable addable){
        for (String word : words) {
            System.out.print(addable.add(word)+ " ");
        }
        System.out.println();
    }
//    public static void performAddOperation(String[]words,Addable addable){
//        for (String word : words) {
//            System.out.print(addable.add(word)+ " ");
//        }
//        System.out.println();
//    }
    public static void performRemoveOperation(int counter,AddRemovable addRemovable){
        for(int i=0 ;i<counter ;i++){
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();
    }
}
