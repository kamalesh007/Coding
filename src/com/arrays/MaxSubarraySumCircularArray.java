package com.arrays;

public class MaxSubarraySumCircularArray {

    public static void main(String[] args)
    {
        int[] arr = {8, -1, 3, 4, -6, 7, 5, -2};

        int maxSumNoWrap = kadane(arr);

        int totalSum = 0;

        for(int i = 0 ; i < arr.length ; i++)
        {
            totalSum += arr[i];

            arr[i] = -arr[i];
        }

        int minSumSubArray = -kadane(arr);

        int maxSumWrap = totalSum - minSumSubArray;


        System.out.println(Math.max(maxSumWrap,maxSumNoWrap));

    }

    public static int kadane(int[] arr)
    {
        int sum = 0;

        int ans = arr[0]; // can be integer.minvalue

        for(int i = 0 ; i < arr.length ; i++)
        {
            sum += arr[i];

            ans = Math.max(ans,sum);

            if(sum < 0 ) sum = 0 ; // start afresh
        }

        return ans;



    }


}
