package scaler.DP;

public class MinPathSumMatrix {

    public int minPathSum(int[][] arr,int row,int col)
    {
        if(col < 0 || row < 0) return Integer.MAX_VALUE;
        if(row == 0 && col == 0) return arr[row][col];

        return Math.min(minPathSum(arr,row-1,col) , minPathSum(arr,row,col-1)) + arr[row][col];
    }

    public static void main(String[] args) {
        MinPathSumMatrix m = new MinPathSumMatrix();
        int[][] arr = new int[][]{{2,3,5},{1,6,4},{9,2,7}};
        System.out.println(m.minPathSum(arr,2,2));
    }
}
