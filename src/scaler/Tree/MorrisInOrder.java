package scaler.Tree;

public class MorrisInOrder {

    public Node rightMostNode(Node root)
    {
        Node temp = root.left;
        while(temp.right != null && temp.right != root)
        {
            temp = temp.right;
        }
        return temp;
    }

    public Node inOrder(Node root)
    {
        Node cur = root;

        while(cur != null)
        {
            if(cur.left ==  null)
            {
                System.out.println(cur.data);
                cur = cur.right;
            }
            else
            {
                Node R = rightMostNode(cur);
                if(R.right == null)
                {
                    R.right = cur;
                    cur = cur.left;
                }
                else
                {
                    System.out.println(cur.data);
                    R.right = null;
                    cur = cur.right;
                }
            }
        }
        return root;
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
        new MorrisInOrder().inOrder(root);
    }

}
