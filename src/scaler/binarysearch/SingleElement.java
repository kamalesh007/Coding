package scaler.binarysearch;

public class SingleElement {

    public static void main(String[] args) {
        int[] A = new int[]{-2,-2,1,2,2};
        int l = 0;
        int h = A.length - 1;
        while(l <= h)
        {
            int mid = l + (h - l >> 1);
            if(mid != 0 && A[mid] == A[mid-1])
            {
                mid --;
            }

            if(mid % 2 == 0)
            {
                l = mid + 2;
            }
            else
            {
                h = mid - 1;
            }
        }
        System.out.println(A[h]);
    }
}
