package scaler.Tree;

public class MorrisPreOrder {

    public void preOrder(Node root)
    {
        Node cur = root;
        while(cur != null)
        {
            if(cur.left == null)
            {
                System.out.println(cur.data);
                cur = cur.right;
            }
            else
            {
                Node R = rightMostNode(cur);
                if(R.right == null) // Seeing curr for first time
                {
                    System.out.println(cur.data);
                    R.right = cur.right;
                    cur = cur.left;
                }
                else
                {
                    R.right = null;
                    cur = cur.right;
                }
            }
        }

    }

    public Node rightMostNode(Node cur)
    {
        Node temp = cur.left;
        while(temp.right != null && temp.right != cur)
        {
            temp = temp.right;
        }
        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        // Manually create the tree structure
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        new MorrisPreOrder().preOrder(root);

        // Second time is only to to restore the link
        // other wise we can point to R.right to cur.right;
    }

}
