package scaler.sorting;

public class Partitioning {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,8,1,6,5,8};
        int X = 0;

      /*  int ptr = 0 ; // putting smaller numbers on the left
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] < X)
            {
                // swap arr[ptr] with i and do ptr++
                int temp = arr[ptr];
                arr[ptr] = arr[i];
                arr[i]= temp;
                ptr++;
            }
        }
        // works fine
        System.out.println(ptr);  */

        // Putting larger numbers on the right

        int ptr = arr.length - 1;

        // ptr holds last smaller number
        for(int i = arr.length -1 ; i >= 0 ; i --)
        {
            if(arr[i] > X )
            {
                int temp = arr[ptr];
                arr[ptr] = arr[i];
                arr[i]= temp;
                ptr--;
            }
        }
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.println(arr[i]);
        }


    }

}
