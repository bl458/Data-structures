package algorithm;

public class BinarySearch {
    //Array has to be sorted beforehand
    //O(logn)
    public int searchIter(int[] arr, int a) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < a) 
                high = mid;
            else if (arr[mid] > a) 
                low = mid;
            else 
                return mid;
        }

        return -1;
    }
}
