package com.arrays;

public class MaxSumSubMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        System.out.println(getMaxSumSubMatrix(matrix));
    }


    public static int getMaxSumSubMatrix(int[][] arr)
    {
        int ans = Integer.MIN_VALUE;

        int rows = arr.length;
        int cols = arr[0].length;


        for(int L = 0 ; L < cols ; L++)
        {
            int[] runningRowSum = new int[rows];

            for(int R = L ; R < cols ; R++)
            {
                for(int i = 0 ; i < rows ; i++)
                {
                    runningRowSum[i] += arr[i][R];
                }

                int currMaxSumSubarray = getMaxSumSubarray(runningRowSum);

                ans = Math.max(ans,currMaxSumSubarray);

            }
        }

        return ans;
    }


    public static int getMaxSumSubarray(int[] arr)
    {
        int ans = arr[0];
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++)
        {
            sum += arr[i];

            ans = Math.max(ans,sum);

           if(sum < 0) sum = 0;
        }
        return ans;
    }

}
