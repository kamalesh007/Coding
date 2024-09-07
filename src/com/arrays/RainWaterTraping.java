package com.arrays;

public class RainWaterTraping {

    public static void main(String[] args) {

        int[] A = {6,4,3,5,1,7,3,5};

        int N = A.length;

        int lMax = A[0];

        int rMax = A[N - 1];

        int i = 0 ;
        int j = N - 1;

        int ans = 0;

        while(i < j)
        {
            if(A[i] < A[j])
            {
                lMax = Math.max(A[i],lMax);
                ans += (lMax - A[i]);
                i++;
            }
            else
            {
                rMax = Math.max(A[j],rMax);
                ans += (rMax - A[j]);
                j --;
            }
        }

        System.out.println(ans);


    }
}
