package scaler.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SpecialMedian {

    public static void main(String[] args) {
        PriorityQueue<Long> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> right = new PriorityQueue<>();
        List<Integer> A = List.of(4,6,8,4);
        left.add(0L + A.get(0));
        for(int i = 1 ; i < A.size() ; i++)
        {
            long element = A.get(i);
            int size = i ;
            if(size % 2 != 0 )
            {
                if(left.peek() == element)
                {
                    System.out.println(1);
                    break;
                }
                if(element < left.peek())
                {
                    right.add(left.remove());
                    left.add(element);
                }
                else
                {
                    right.add(element);
                }
            }
            else
            {
                if(element * 2 == left.peek()  + right.peek() )
                {
                    System.out.println(1);
                    break;
                }

                if(element < right.peek())
                {
                    left.add(element);
                }
                else
                {
                    left.add(right.remove());
                    right.add(element);
                }
            }
        }

        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        left.add(0L + A.get(A.size() - 1));


        for(int i = A.size() - 2 ; i >= 0; i -- )
        {
            long element = A.get(i);
            int size = A.size() - 1 - i ;
            if(size % 2 != 0 )
            {
                if(left.peek() == element)
                {
                    System.out.println(1);
                    break;
                }
                if(element < left.peek())
                {
                    right.add(left.remove());
                    left.add(element);
                }
                else
                {
                    right.add(element);
                }
            }
            else
            {
                if(element * 2 == left.peek()  + right.peek() )
                {
                    System.out.println(1);
                    break;
                }

                if(element < right.peek())
                {
                    left.add(element);
                }
                else
                {
                    left.add(right.remove());
                    right.add(element);
                }
            }
        }

        System.out.println(0);



    }
}
