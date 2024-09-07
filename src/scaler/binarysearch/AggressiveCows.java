package scaler.binarysearch;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        int C = 3 ;

        int low = 1;
        int high = (arr[arr.length-1] - arr[0]) / (C - 1);

        while(low <= high)
        {
            int mid = low + (high - low >> 1);
            if(!check(arr,mid,C))
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println(high);
    }

    public static boolean check(int[] arr,int minDistance,int cows)
    {
        int curDiff = 0;
        int divisions = 0;
        for(int i = 1 ; i < arr.length ;i ++)
        {
            int prevDiff = arr[i] - arr[i-1];
            curDiff += prevDiff;
            if(curDiff >= minDistance)
            {
                divisions ++;
                curDiff = 0;
            }
        }
        return cows <= divisions + 1;
    }
}
