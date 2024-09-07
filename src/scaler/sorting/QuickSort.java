package scaler.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = qSort(new int[]{5,-1, -1 ,3,2,1,-1},0,6);
        for(Integer i : arr)
        {
            System.out.println(i);
        }
    }

    public static int[] qSort(int[] arr,int start,int end)
    {
        if(start >= end)
            return arr;

        int pIdx = partition(arr,start,end);
        qSort(arr,start,pIdx-1);
        qSort(arr,pIdx + 1 , end);
        return arr;
    }

    public static int partition(int[] arr, int start,int end)
    {
        int pivot = arr[end];

        int ptr = start;

        for(int i = start ; i < end ; i++)
        {
            if(arr[i] < pivot)
            {
                int temp = arr[ptr];
                arr[ptr] = arr[i];
                arr[i] = temp;
                ptr++;
            }
        }

        int temp = arr[ptr];
        arr[ptr] = arr[end];
        arr[end] = temp;

        return ptr;


    }
}
