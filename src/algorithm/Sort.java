package algorithm;

//Cannot be instantiated
public abstract class Sort {
    //Sorts in ascending
    public abstract void sort(int[] values);

    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
