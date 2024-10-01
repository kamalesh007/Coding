package scaler.DP.Knapsack;

import java.util.Arrays;

public class ZeroOne {

    public int maxProfit(int index,int capacity,int[] happiness,int[] weight,int curHappiness)
    {
        if(index == happiness.length) return curHappiness;

        if(weight[index] > capacity) return maxProfit(index + 1,capacity,happiness,weight,curHappiness);

        int max = maxProfit(index + 1,capacity,happiness,weight,curHappiness);
        max = Math.max(max,maxProfit(index + 1,capacity - weight[index],happiness,weight,curHappiness + happiness[index]));
        return max;
    }


    public int zeroOneBrute(int capacity,int[] wt,int[] happiness,int index)
    {
        if(index == wt.length) return 0;

        if(wt[index] > capacity)
            return zeroOneBrute(capacity,wt,happiness,index + 1) ;

        else
            return Math.max(zeroOneBrute(capacity,wt,happiness,index + 1),
                    happiness[index] + zeroOneBrute(capacity - wt[index],wt,happiness,index + 1));

    }

    public int zeroOneRecDP(int[] wt,int[] happiness,int index,int capacity,int[][] dp)
    {
        if(index == wt.length) return 0;
        if(dp[index][capacity] != -1) return dp[index][capacity];
        else
        {
            dp[index][capacity] = 0;
            if(wt[index] > capacity) dp[index][capacity] = zeroOneRecDP(wt,happiness,index + 1,capacity,dp);
            else
            {
                dp[index][capacity] = Math.max(
                        zeroOneRecDP(wt,happiness,index + 1,capacity,dp),
                      happiness[index] + zeroOneRecDP(wt,happiness,index + 1,capacity - wt[index],dp)
                );

            }
            return dp[index][capacity];
        }
    }

    public int zeroOneItrDP(int[] wt,int[] happiness,int capacity)
    {
        int[][] dp = new int[wt.length + 1][capacity + 1];
        for(int i = 0 ; i < dp.length ; i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i < dp[0].length ;i ++)
        {
            dp[0][i] = 0;
        }

        for(int i = 0 ; i < wt.length ; i++)
        {
            for(int j = 1 ; j <= capacity ; j++)
            {
                if(j >= wt[i])
                {
                    dp[i+1][j] = Math.max(dp[i][j] , happiness[i] + dp[i][j - wt[i]]);
                }
                else
                {
                    dp[i+1][j] = dp[i][j];
                }

            }
        }
        return dp[wt.length][capacity];

    }





    public static void main(String[] args) {
        int[] happiness = new int[]{4,1,5,7};
        int[] weight = new int[]{3,2,4,5};
        ZeroOne zeroOne = new ZeroOne();
        int capacity = 7;

        int[][] dp = new int[weight.length + 1][capacity + 1];
        for(int i = 0 ; i < dp.length ; i++)
        {
            Arrays.fill(dp[i] , -1);
        }
        System.out.println(zeroOne.maxProfit(0,7,happiness,weight,0));
        System.out.println(zeroOne.zeroOneBrute(7,weight,happiness,0));
        System.out.println(zeroOne.zeroOneRecDP(weight,happiness,0,capacity,dp));
        System.out.println(zeroOne.zeroOneItrDP(weight,happiness,capacity));

    }
}
