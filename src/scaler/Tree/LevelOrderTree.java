package scaler.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree {

    public TreeNextNode levelOrder(TreeNextNode root)
    {
        ArrayDeque<TreeNextNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNextNode last = root;
        while(!q.isEmpty())
        {
            TreeNextNode front = q.remove();
            if(front.left != null)
            {
                q.add(front.left);
            }
            if(front.right != null)
            {
                q.add(front.right);
            }

            if(front == last)
            {
                front.next = null;
                last = (!q.isEmpty())? q.getLast() : null;
            }
            else
            {
                front.next = q.getFirst();
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
