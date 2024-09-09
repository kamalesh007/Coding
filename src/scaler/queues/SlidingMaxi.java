package scaler.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingMaxi {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,5,6,7,4,2,10,3};
        int B = 4;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < B ; i++)
        {
            while(!q.isEmpty() && arr[q.getLast()] <= arr[i])
            {
                q.removeLast();
            }
            q.offerLast(i);
        }

        System.out.println(arr[q.getFirst()]);

        for(int i = B ; i < arr.length ; i++)
        {
            int idxToRemove = i - B ;
            if(q.getFirst() == idxToRemove)
            {
                q.removeFirst();
            }

            while(!q.isEmpty() && arr[q.getLast()]< arr[i])
            {
                q.removeLast();
            }

            q.offerLast(i);

            System.out.println(arr[q.getFirst()]);
        }



    }
}
