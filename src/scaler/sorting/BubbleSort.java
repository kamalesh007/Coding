package scaler.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5,4,3,2,1};
      //  int j = arr.length ;
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0; j < arr.length - i  - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.println(arr[i]);
        }





    }
}
