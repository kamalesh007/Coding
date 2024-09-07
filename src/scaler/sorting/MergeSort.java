package scaler.sorting;


public class MergeSort {

    public static int[] sort(int[] A ,int start,int end)
    {
        if(start == end)
        {
            int[] arr = new int[1];
            arr[0] = A[start];
            return arr;
        }
        int mid = start + ( (end - start) >> 1);
       // int mid = start; // T (n-1) + O(N);
        int[] left = sort(A,start,mid);
        int[] right = sort(A,mid+1,end);
        int[] merged = merge(left,right);
        return merge(left,right);

    }

    public static int[] merge(int[] A,int[] B)
    {
        int[] merge = new int[A.length+ B.length];

        int l = 0 ;
        int r = 0;

        for(int i = 0 ; i < merge.length ; i++)
        {
            if(l == A.length)
            {
                merge[i] = B[r++];
            }
            else  if (r == B.length)
            {
                merge[i] = A[l++];
            }
            else if(A[l] <= B[r])
            {
                merge[i] = A[l++];
            }
            else
            {
                merge[i] = B[r++];
            }

        }
        return merge;
    }

    public static void main(String[] args) {
        int[] arr = sort(new int[]{4,5,1,2,6,3},0,5);
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.println(arr[i]);
        }
    }

}



