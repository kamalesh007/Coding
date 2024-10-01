package scaler.DP.Knapsack;

import java.util.Arrays;

public class CoinSum {

    public int ans;
    public void solve(int capacity,int[] coins)
    {
        if(0 == capacity)
        {
            ans ++;
            return;
        }
        for(int i = 0 ; i < coins.length ; i++)
        {
            if(coins[i] <= capacity)
            {
                solve(capacity - coins[i] , coins);
            }
        }
    }

    public void solve(int capacity,int[] coins,int index)
    {
        if(capacity == 0)
        {
            ans++;
            return;
        }
        for(int i = index ; i <coins.length ; i++)
        {
            if(coins[i] <= capacity)
            {
                solve(capacity-coins[i],coins,i);
            }
        }
    }

    public int itrOrderedCoinSim(int capacity)
    {
        int[] dp = new int[capacity + 1];
        return -1;
    }

    public int recOrdererdCoinSum(int capacity,int[] coins,int[] dp)
    {
        if(capacity == 0) return 1;
        if(dp[capacity] != 0) return dp[capacity];

        for(int i = 0 ; i < coins.length ; i++)
        {
            if(coins[i] <= capacity)
            {
                dp[capacity] += recOrdererdCoinSum(capacity - coins[i],coins,dp);
            }
        }
        return dp[capacity];
    }

    public int recUnOrderedCoinSum(int capacity, int[] coins, int[] dp, int index) {
        if (capacity == 0) return 1;  // Base case: one way to make 0 (no coins)
        if (dp[capacity] != -1) return dp[capacity];  // Memoization check

        dp[capacity] = 0;  // Initialize dp for this capacity

        for (int i = index; i < coins.length; i++) {
            if (coins[i] <= capacity) {
                dp[capacity] += recUnOrderedCoinSum(capacity - coins[i], coins, dp, i);
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{3,1,4};
        int capacity = 5;
        CoinSum coinSum = new CoinSum();
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp,-1);
        System.out.println(coinSum.recUnOrderedCoinSum(capacity,coins,dp,0));

    }
}
