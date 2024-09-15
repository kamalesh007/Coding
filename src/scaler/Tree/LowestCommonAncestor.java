package scaler.Tree;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestor {

    public Map<Node,Pair<Integer,Integer>> nodeVsTime;
    public int T;
    public void InOutTime(Node root)
    {
        if(root == null) return;
        T ++;
        nodeVsTime.put(root,new Pair(T,0));
        InOutTime(root.left);
        InOutTime(root.right);
        T ++;
        Pair<Integer,Integer> temp = nodeVsTime.get(root);
        temp.right = T;
        nodeVsTime.put(root,temp);
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.nodeVsTime = new HashMap<>();
        lca.T = 0;

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right.right = new Node(10);
        lca.InOutTime(root);
    }

}


