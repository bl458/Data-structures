package algorithm.sort; 

public class MergeSort extends Sort {
    public void sort(int[] values) {
        sortHelper(values, 0, values.length-1);
    }

    private void sortHelper(int[] values, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sortHelper(values, low, mid);
            sortHelper(values, mid+1, high);
            merge(values, low, mid, high);
        }
    }

    private void merge(int[] values, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] leftHalf = new int[n1];
        int[] rightHalf = new int[n2];
        for (int i=0; i<n1; i++) 
            leftHalf[i] = values[low + i];
        
        for (int i=0; i<n2; i++) 
            rightHalf[i] = values[mid + 1 + i];
        
        int pointer = low;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < n1 && pointer2 < n2) {
            if (leftHalf[pointer1] < rightHalf[pointer2]) 
                values[pointer++] = leftHalf[pointer1++];
            else 
                values[pointer++] = rightHalf[pointer2++];
        }

        while (pointer1 < n1) 
            values[pointer++] = leftHalf[pointer1++];
        
        while (pointer2 < n2) 
            values[pointer++] = rightHalf[pointer2++];
    }
}
