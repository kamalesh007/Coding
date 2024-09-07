package scaler.binarysearch;

public class PeakElement {

    public static void main(String[] args) {
        int[] A = new int[]{10,5,4};
        int low = 0;
        int high = A.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low >> 1);
            if(mid == 0 || A[mid - 1] < A[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        System.out.println(A[high]);

    }
}
