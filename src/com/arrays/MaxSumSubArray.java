package com.arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-5,-1,-3,-1};

        int curL = 0;
        int L = 0 ;
        int R = 0;
        int ans = arr[0];
        int sum = 0 ;

        for(int i = 0 ; i < arr.length ; i++)
        {
            sum += arr[i];

            if(sum > ans)
            {
                L = curL;
                R = i;
                ans = sum;
            }

            if(sum < 0)
            {
                curL = i + 1;
                sum = 0;
            }

        }
        System.out.println(curL);

        System.out.println("L:"+L +", R:"+R);






    }



}
