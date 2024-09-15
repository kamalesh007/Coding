package scaler.Tree;

public class FlattenPreOrder {

    public Node preOrder(Node root)
    {
        Node cur = root;
        while(cur != null)
        {
            if(cur.left == null)
            {
                cur = cur.right;
            }
            else
            {
                Node R = rightMostNode(cur);
                if(R.right == null) // Seeing curr for first time
                {
                    R.right = cur.right;
                   cur.right = cur.left;
                   cur.left = null;
                   cur = cur.right;
                }
            }
        }

        return root;

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
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);


        root = new FlattenPreOrder().preOrder(root);
    }

}
