package scaler.DP.Knapsack;

import java.util.Arrays;

public class CoinChange {

    public int recUnOrderedCoinSum(int capacity, int[] coins, int[][] dp, int index) {
        // Base case: if capacity is 0, there's exactly 1 way to make the sum (by choosing no coins)
        if (capacity == 0) return 1;

        // Check if this subproblem has already been solved
        if (dp[capacity][index] != -1) return dp[capacity][index];

        // Initialize dp[capacity] to 0 (no ways yet calculated)
        dp[capacity][index] = 0;

        // Loop through coins, but only consider coins from the current index onwards to avoid overcounting
        for (int i = index; i < coins.length; i++) {
            if (coins[i] <= capacity) {
                int temp = recUnOrderedCoinSum(capacity - coins[i], coins, dp, i);  // Recursive call
                dp[capacity][index] += temp;
            }
        }

        return dp[capacity][index];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins = {3,1,4};  // Given coins
        int capacity = 5;         // Target sum

        // Initialize dp array
        int[][] dp = new int[capacity + 1][coins.length];
        for(int i = 0 ; i < dp.length;i++)
        {
            Arrays.fill(dp[i], -1);  // Fill dp array with -1 to mark unsolved states
        }


        // Call the recursive function
        int result = cc.recUnOrderedCoinSum(capacity, coins, dp, 0);
        System.out.println("Number of ways to make sum 5: " + result);
    }
}
