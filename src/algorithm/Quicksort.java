package algorithm;

public class Quicksort extends InplaceSort {
    public void sort(int[] values) {
        sortHelper(values, 0, values.length-1);
    }

    private void sortHelper(int[] values, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(values, low, high);
            sortHelper(values, low, pivotIdx-1);
            sortHelper(values, pivotIdx+1, high);
        }
    }

    //We will be partitioning arr from low idx to high idx into two partitions. 
    //High idx is the pivot by default. 
    private int partition(int[] values, int low, int high) {
        int pivot = values[high];
        
        int i = low-1;
        int j = low;
        while (j <= high) {
            if (j == high || values[j] < pivot) 
                swap(values, ++i, j);
            
            j++;
        }
        
        return i;
    }
}
