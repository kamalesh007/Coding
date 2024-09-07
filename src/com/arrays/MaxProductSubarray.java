package com.arrays;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int ans = Integer.MIN_VALUE;
        int minProduct = nums[0];
        int maxProduct = nums[0];

        for(int i = 1 ; i < nums.length ;i ++)
        {
            if(nums[i] > 0)
            {
                minProduct = Math.min(minProduct * nums[i] , nums[i]);
                maxProduct = Math.max(maxProduct * nums[i] , nums[i]);
            }
            else
            {
                int oldMin = minProduct;
                minProduct = Math.min(nums[i],maxProduct * nums[i]);
                maxProduct = Math.max(nums[i],oldMin * nums[i]);
            }
            ans = Math.max(ans,maxProduct);
        }
        System.out.println(ans);

    }
}
