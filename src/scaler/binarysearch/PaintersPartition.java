package scaler.binarysearch;

public class PaintersPartition {

    public static void main(String[] args) {
        int[] arr = new int[]{10,6,12,2,18};

        int painters = 3;

        int low = arr[0];
        int high = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            low = Math.max(low,arr[i]);
            high += arr[i];
        }

        while(low <= high)
        {
            int mid = low + (high - low >> 1);
            if(check(arr,painters,mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println(low);

    }

    public static boolean check(int[] timeArr,int painters,int minTime)
    {
        int cnt = 1;
        int sum = 0;
        for(int i = 0 ; i < timeArr.length ; i++)
        {
            sum += timeArr[i];
            if(sum > minTime)
            {
                sum  = timeArr[i];
                cnt++;
            }
        }
        return cnt <= painters;

    }

}
