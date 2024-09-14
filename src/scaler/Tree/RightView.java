package scaler.Tree;

public class RightView {

    public int maxLevel = 0;
    public void rightView(Node root,int level)
    {
        if(root == null) return;
        if(level == this.maxLevel)
        {
            System.out.println(root.data);
            this.maxLevel = this.maxLevel + 1;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);

    }
    public static void main(String[] args) {
        Node root = new Node(1);

        // Manually create the tree structure
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(8);
        root.right.left = new Node(10);
        root.right.right = new Node(13);
        root.left.left.left = new Node(6);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(7);
        root.right.right.left = new Node(4);
        root.right.left.right.left = new Node(12);
        new RightView().rightView(root,0);
    }
}
