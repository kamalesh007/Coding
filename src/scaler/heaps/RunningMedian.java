package scaler.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {
        int[] arr = new int[]{9,8,17,20,25,10,5,3};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int median = 9;
        System.out.println(median );

        for(int i = 1 ; i < arr.length ; i++)
        {
            int size = i + 1;
            if(arr[i] < median)
            {
                maxHeap.add(arr[i]);
            }
            else
            {
                minHeap.add(arr[i]);
            }

            if((size & 1) == 0) // even
            {
                if(maxHeap.size() > minHeap.size())
                {
                    minHeap.add(median);
                    median = maxHeap.remove();
                }
            }
            else
            {
                if(minHeap.size() > maxHeap.size())
                {
                    maxHeap.add(median);
                    median = minHeap.remove();
                }
            }
            System.out.println(median);
        }


    }
}
