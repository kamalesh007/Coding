package scaler.Tree;

public class FlattenInOrder {

    public PairFlatten flatten(Node root)
    {
        if(root == null) return new PairFlatten(null,null);

        PairFlatten L = flatten(root.left);
        PairFlatten R = flatten(root.right);

        root.left = null;

        if(L.head == null && R.head == null) return new PairFlatten(root,root);
        else if(L.head == null && R.head != null)
        {
            root.right = R.head;
            return new PairFlatten(root,R.tail);
        }
        else if(R.head == null && L.head != null)
        {
            L.tail.left = null;
            L.tail.right = root;
            return new PairFlatten(L.head,root);
        }
        else
        {
            L.tail.left = null;
            L.tail.right = root;
            root.right = R.head;
            return new PairFlatten(L.head,R.tail);
        }
    }

    public static void main(String[] args) {
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

//        Node root = new Node(7);
//        root.left = new Node(8);
//        root.right = new Node(9);
//        root.right.right = new Node(10);

        PairFlatten p =new FlattenInOrder().flatten(root);
        p = p;
    }

}

class PairFlatten
{
    public Node head;
    public Node tail;

    PairFlatten(Node left, Node right)
    {
        this.head = left;
        this.tail = right;
    }
}
