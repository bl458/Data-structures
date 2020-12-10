package algorithm;

public class InsertionSort extends Sort {
    public void sort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int left = i-1;
            while (left >= 0) {
                if (arr[left] > arr[left+1]) {
                    swap(arr, left, left+1);
                    left--;
                }
                else break;
            }
        }       
    }
}
