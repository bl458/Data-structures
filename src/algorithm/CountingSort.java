package algorithm;

import java.util.Arrays;

public class CountingSort extends Sort {
    public void sort(int[] values) {
        int max = Arrays.stream(values).max().getAsInt();
        int min = Arrays.stream(values).min().getAsInt();
        int range = max - min + 1; 
        int[] count = new int[range]; 
        int[] output = new int[values.length];

        //Initialize count
        for (int i=0; i<values.length; i++) 
            count[values[i] - min]++;
        
        //Get cumulative sum for count 
        for (int i=1; i<count.length; i++)  
            count[i] += count[i-1];
        
        //Sort values using cumul sum of counts. Sorted output is put into output
        for (int i=values.length-1; i>=0; i--) {
            output[count[values[i] - min] - 1] = values[i]; 
            count[values[i] - min]--;
        }

        //Insert output's values into our original array values to sort values
        for (int i=0; i<values.length; i++) 
            values[i] = output[i];
    }
}