package scaler.heaps;

public class Heap {

    public int[] buildHeap(int[] arr)
    {
        int N = arr.length;
        int start = (N - 1) - ( N + 1 >> 1);
        for(int i = start ; i >= 0 ; i --)
        {
            int lc = arr[2 * i + 1];
            int rc = arr[2 * i + 2];

            if(arr[i] < lc || arr[i] < rc)
            {
                int j =  i ;
                int lIdx = 2 * i + 1;
                int rIdx = 2 * i + 2;

                while(lIdx < N && rIdx < N && (arr[j] < arr[lIdx] || arr[j] < arr[rIdx]))
                {
                    if(arr[lIdx] > arr[rIdx])
                    {
                        int temp = arr[lIdx];
                        arr[lIdx] = arr[j];
                        arr[j] = temp;
                        j = lIdx;
                    }
                    else
                    {
                        int temp = arr[rIdx];
                        arr[rIdx] = arr[j];
                        arr[j] = temp;
                        j = rIdx;
                    }

                    lIdx = 2 * j + 1;
                    rIdx = 2 * j + 2;
                }

            }
        }
        return arr;
    }

    

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = new int[]{7,3,5,1,5,6,8,2,4};
        heap.buildHeap(arr);
        for (int ar : arr)
        {
            System.out.println(ar);
        }
    }
}
