package scaler.Tree;

public class PathSum {

    public int neededSum;
    public boolean isPathSumAvail(Node root,int curSum)
    {
        if(root == null) return false;
        curSum += root.data;
        if(root.left == null && root.right == null)
        {
            return curSum == neededSum;
        }

        return isPathSumAvail(root.left,curSum) || isPathSumAvail(root.right,curSum);
    }
}
