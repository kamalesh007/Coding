package scaler.binarysearch;

public class LowerBound {

    public static void main(String[] args) {
        int[] A = new int[]{2,2,5,5,5,5,8,10,10,13,13,13};
        int l = 0 ;
        int h = A.length - 1;
        int X = 5;
        while(l <= h)
        {
            int mid = l + (h - l >> 1);
            if(A[mid] < X)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }

        System.out.println(l);
    }
}
