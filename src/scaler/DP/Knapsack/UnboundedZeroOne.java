package scaler.DP.Knapsack;

import java.util.Arrays;

public class UnboundedZeroOne {

    int[][] dp;
    public int solve(int capacity,int profit,int[] happiness,int[] wt,int index)
    {
        int ans = profit;
        for(int i = index ; i < happiness.length ; i++)
        {
            if(wt[i] <= capacity)
            {
             ans = Math.max(ans,solve(capacity - wt[i],profit + happiness[i],happiness,wt,i));
            }
        }
        return ans;
    }

    public int itrUnboundedZeroOneDp(int capacity,int[] happiness,int[] wt)
    {
        int[] dp = new int[capacity + 1];
        dp[0] = 0;
        for(int i = 1 ; i <= capacity ; i++)
        {
            for(int j = 0 ; j <= wt.length ; j++)
            {
                if(wt[j] <= i)
                {
                    dp[i] = Math.max(dp[i],happiness[j] + dp[i - wt[j]]);
                }
            }
        }
        return dp[capacity];
    }

    public int recUnboundedZeroOneDp(int capacity,int[] dp,int[] happiness,int[] wt, int profit)
    {
        if(dp[capacity] != 0)
        {
            return dp[capacity];
        }
        dp[capacity] = 0;
        for(int i = 0 ; i < wt.length ; i++)
        {
            if(wt[i] <= capacity)
            {
                dp[capacity] = Math.max(dp[capacity] , happiness[i] + recUnboundedZeroOneDp(capacity-wt[i]
                        ,dp,happiness,wt,profit +happiness[i]));
            }
        }
        return dp[capacity];
    }

    public int recDPUnbounded01(int capacity,int[] wt,int[] happiness,int[] dp)
    {
        if(capacity == 0) return 0;
        if(dp[capacity] != -1)return dp[capacity];
        dp[capacity] = 0;
        for(int i = 0 ; i < wt.length ; i++)
        {
            if(wt[i] <= capacity)
            {
                dp[capacity] = Math.max(dp[capacity],happiness[i] + recDPUnbounded01(capacity - wt[i],wt,happiness,dp));
            }
        }
        return dp[capacity];
    }


    public int bruteUnbounded01(int capacity,int[] wt,int[] happiness)
    {
        if(capacity == 0) return 0;
        else{
            int ans = 0;
            for(int i = 0 ; i < wt.length ; i++)
            {
                if(wt[i] <= capacity)
                {
                    ans = Math.max(ans,happiness[i] + bruteUnbounded01(capacity - wt[i] ,wt,happiness));
                }
            }
            return ans;
        }
    }

    public int itrDPUnbounded01(int capacity,int[] wt,int[] happiness)
    {
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp , 0);
        for(int i = 1; i <= capacity ; i++)
        {
            for(int j = 0 ; j < wt.length ; j++)
            {
                if(wt[j] <= i)
                {
                    dp[i] = Math.max(dp[i], happiness[j] + dp[i - wt[j]]);
                }
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args) {
        int[] h = new int[]{1,4,2,5,6};
        int[] wt = new int[]{1,2,3,4,5};
        UnboundedZeroOne unboundedZeroOne = new UnboundedZeroOne();
        System.out.println(unboundedZeroOne.solve(5,0,h,wt,0));
        int[] hh = new int[]{2,3,5};
        int[] wwt = new int[]{3,4,7};
        int capacity = 8;
        System.out.println(unboundedZeroOne.recUnboundedZeroOneDp(8,new int[9],hh,wwt,0));
        System.out.println(unboundedZeroOne.bruteUnbounded01(capacity,wwt,hh));
        int[] dp= new int[capacity + 1];
        Arrays.fill(dp,-1);
        System.out.println(unboundedZeroOne.recDPUnbounded01(capacity,wwt,hh,dp));
        System.out.println(unboundedZeroOne.itrDPUnbounded01(capacity,wwt,hh));
    }
}
