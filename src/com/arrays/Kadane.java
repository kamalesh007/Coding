package com.arrays;

public class Kadane {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,1,1,1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,1,1,-1,1};

       int sum = 0;
       int L = 0 ;
       int R = 0;
       int tempL = 0;
       int maxSum = arr[0];

       for(int i = 0 ; i < arr.length ; i++)
       {
          sum += arr[i];
          if(sum >= maxSum)
          {
            maxSum = sum;
            int len = R - L + 1;
            int cLen = i - tempL + 1;
            if(cLen > len)
            {
                R = i;
                L = tempL;
            }
          }
          if(sum < 0)
          {
              sum = 0;
              tempL = i + 1;
          }
       }
        System.out.println(maxSum);
        System.out.println(L);
        System.out.println(R);



    }
}
