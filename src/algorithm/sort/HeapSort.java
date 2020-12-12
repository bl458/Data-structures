package algorithm.sort;

import java.util.Arrays;

//Sort in ascending order using max heap
public class HeapSort extends Sort {
    private void heapify(int[] values, int low, int high) {
        int l = low * 2 + 1;
        int r = low * 2 + 2;

        while (true) {
            if (low <= l && l <= high  && values[low] < values[l]) 
                swap(values, low, l);
            else if (low <= r && r <= high && values[low] < values[r]) 
                swap(values, low, r);
            else break;
        }
    }
    
    public void sort(int[] values) {
        for (int i=values.length/2-1; i>=0; i--) 
            heapify(values, i, values.length-1);
                
        for (int i=values.length-1; i>0; i--) {
            swap(values, 0, i);
            heapify(values, 0, i-1);
        }
    }    
}
