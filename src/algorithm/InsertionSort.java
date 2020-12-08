package algorithm;

public class InsertionSort implements InplaceSort {
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

    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
