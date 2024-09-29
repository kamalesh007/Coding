package scaler.DP;

public class Princess {

    public int minHealth(int[][] arr, int row,int col)
    {
        int[][] dp = new int[row + 1][col +1];
        dp[row][col] = Math.max(1, 1 - arr[row][col]);
        for(int i = row - 1 ; i >= 0 ; i --)
            dp[i][col] = Math.max(1,dp[i+1][col] - arr[i][col]);

        for(int i = col - 1 ; i >=0 ; i--)
            dp[row][i] = Math.max(1,dp[row][i+1] - arr[row][i]);

        for(int i =  row - 1 ; i >=0 ; i--)
        {
            for(int j = col - 1 ; j >=0 ; j--)
            {
                int min = Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = Math.max(1,min - arr[i][j]);
            }
        }

        for(int i = 0 ; i <= row ; i ++)
        {
            for(int j = 0 ; j <= col ; j ++)
            {
                System.out.print(dp[i][j] +"\t");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Princess princess = new Princess();
        int[][] arr = new int[][]{{-3,2,4,-7},{-6,5,-4,6},{-15,-8,3,-4},{7,4,-2,-7}};
        int row = arr.length - 1;
        int col = arr[0].length - 1;
        System.out.println(princess.minHealth(arr,row,col));
    }
}
