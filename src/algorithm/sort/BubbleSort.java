package algorithm.sort;

public class BubbleSort extends Sort {
    public void sort(int[] values) {
        while (true) {
            int swaps = 0;
            for (int i=1; i<values.length; i++) {
                if (values[i-1] > values[i]) {
                    swap(values, i-1, i);
                    swaps++;
                }     
            }

            if (swaps == 0) break;
        }
    }
}