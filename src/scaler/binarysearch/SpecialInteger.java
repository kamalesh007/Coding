package scaler.binarysearch;

/**
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the maximum value of K (sub array length).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = 130
 *
 */


public class SpecialInteger {

    public int solve(int[] A, int B) {

        long[] prefixSum = new long[A.length + 1];
        prefixSum[0] = 0;
        for(int i = 1 ; i <= A.length ; i++)
        {
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }

        int low = 1;
        int high = A.length;

        while(low <= high)
        {
            int mid = low + ((high - low) >> 1);
            boolean check = checkSubarray(prefixSum,mid,B);
            if(check) low = mid + 1;
            else high = mid - 1;
        }
        return high;

    }

    public static boolean checkSubarray(long[] prefixSum,int size,int maxVal)
    {
        for(int i = size ; i < prefixSum.length ; i++)
        {
            long currentSum = prefixSum[i] - prefixSum[i-size];
            if(currentSum > maxVal)
            {
                return false;
            }
        }
        return true;
    }
}
