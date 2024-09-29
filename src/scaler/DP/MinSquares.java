package scaler.DP;

public class MinSquares {

    public int minSquares(int element)
    {
        if(element == 0) return 0;
        if(element == 1) return 1;

        int ans = Integer.MAX_VALUE;

        for(int i = 1 ; i * i <= element ; i++)
        {
            ans = Math.min(ans, 1 + minSquares(element - (i * i)));
        }
        return ans;
    }

    public static void main(String[] args) {
        MinSquares m = new MinSquares();
        System.out.println(m.minSquares(12));
    }
}
