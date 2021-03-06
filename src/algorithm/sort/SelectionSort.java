package algorithm.sort; 

public class SelectionSort extends Sort {
    public void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIdx = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[minIdx] > arr[j]) 
                    minIdx = j;
            }
            
            swap(arr, i, minIdx);
        }
    }
}
