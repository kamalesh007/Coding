package scaler.Tree;

import java.util.Stack;

public class IterativePostOrder {
    public static void main(String[] args) {

        Stack<Node> recursionStack = new Stack<>();

        Node root = new Node(1);

        // Manually create the tree structure
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node cur = root;

        while(cur != null || !recursionStack.isEmpty())
        {
            if(cur != null)
            {
                recursionStack.push(cur);
                cur = cur.left;
            }
            else
            {
                Node peek = recursionStack.peek();
                if(peek.right != null)
                {
                    cur = peek.right;
                }
                else
                {
                    Node popped = recursionStack.pop();
                    System.out.println(popped.data);

                    while(!recursionStack.isEmpty() && recursionStack.peek().right == popped)
                    {
                       popped = recursionStack.pop();
                        System.out.println(popped.data);
                    }
                }
            }
        }


    }
}
