package scaler.DP;

public class NDigit {
    public int count;
    public int[][] dp; // digitsVsNeededSum
    public void dfs(int sum,int level,int maxLevel,int ele)
    {
        if(level == maxLevel)
        {
            if(sum == ele )
            {
                this.count++;
            }

            return;
        }

        for(int i = (level != 0 ? 0 : 1) ; i < 10 ; i++)
        {
            dfs(sum + i , level + 1,maxLevel,ele);
        }
    }

    public int solve(int level,int maxLevel,int neededSum)
    {
        if(neededSum < 0) return 0;
        if(level == maxLevel)
        {
            return neededSum == 0 ? 1 : 0;
        }
        if(dp[level][neededSum] != -1) return dp[level][neededSum];
        int count = 0;
        for(int i =  (level == 0 ? 1 : 0) ; i < 10 ; i++)
        {
            count += solve(level+1,maxLevel,neededSum - i);
        }
        dp[level][neededSum] = count;
        return count;
    }

    public static void main(String[] args) {
        NDigit nDigit = new NDigit();
        nDigit.dfs(0,0,1,3);
       // System.out.println(nDigit.count);
        int digit = 3;
        int sum = 8;
        nDigit.dp = new int[digit][sum + 1];
        for(int i = 0 ; i < nDigit.dp.length ; i++)
            for(int j = 0 ; j < nDigit.dp[0].length ; j++)
                nDigit.dp[i][j] = -1;
        System.out.println(nDigit.solve(0,3,8));
    }
}
