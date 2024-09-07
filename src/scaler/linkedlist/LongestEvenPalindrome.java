package scaler.linkedlist;

public class LongestEvenPalindrome {

    public Node solve(Node head)
    {
        Node h = head;

        Node left = head;
        Node right = head.next;
        Node prev = null;
        while(right != null)
        {
            left.next = prev;
            int ans = 0;
            Node tempL = left;
            Node tempR = right;

            while(tempL != null && tempR!= null && tempL.data == tempR.data)
            {
                ans ++;
                tempL = tempL.next;
                tempR = tempR.next;
            }

            System.out.println(ans * 2);

            prev = left;
            left = right;
            right = right.next;
        }
        left.next = prev;
        return Reverse.reverse(left);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,2};
        System.out.println(new LongestEvenPalindrome().solve(NodeUtils.getListFromArr(arr)));
    }
}
