import algorithm.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // Array<Integer> intArr = new Array<Integer>();
        // intArr.add(1);
        // intArr.add(2);
        // System.out.println(intArr + " " + intArr.size());
        // intArr.remove(0);
        // System.out.println(intArr + " " + intArr.size());
        // intArr.remove(1);
        // System.out.println(intArr + " " + intArr.size());

        // DoublyLinkedList<String> strDLList = new DoublyLinkedList<String>();
        // strDLList.add("b");
        // strDLList.add("d");
        // strDLList.add("c");
        // System.out.println(strDLList + " " + strDLList.indexOf("b") + strDLList.indexOf("d") + strDLList.indexOf("c"));
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("d");
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("b");
        // System.out.println(strDLList + " " + strDLList.size());
        // strDLList.remove("c");
        // System.out.println(strDLList + " " + strDLList.size());

        // Stack<Integer> intStack = new Stack<Integer>();
        // intStack.push(1);
        // intStack.push(2);
        // System.out.println(intStack.toString() + ' ' + intStack.peek());
        // intStack.pop();
        // System.out.println(intStack);

        // String[] arr = {"z", "x", "y"};
        // PQueue<String> intPQueue = new PQueue<>(arr);
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.add("w");
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.add("v");
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.add("u");
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.add("t");
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.poll();
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));
        // intPQueue.remove("v");
        // System.out.println(intPQueue +" " +intPQueue.isMinHeap(0));

        // InsertionSort iSort = new InsertionSort();
        // int[] arr = {7,1,5,3,1,4};
        // iSort.sort(arr);
        // System.out.println(Arrays.toString(arr));

        // SelectionSort sSort = new SelectionSort();
        // int[] arr2 = {7,1,5,3,1,4};
        // sSort.sort(arr2);
        // System.out.println(Arrays.toString(arr2));

        // Quicksort qSort = new Quicksort();
        // int[] arr3 = {7,1,5,3,1,4};
        // qSort.sort(arr3);
        // System.out.println(Arrays.toString(arr3));

        Mergesort mSort = new Mergesort();
        int[] arr4 = {7,1,5,3,1,4};
        mSort.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }   
}
