package scaler.linkedlist;

public class LongestOddPalindrome {

    public Node solve(Node head)
    {
        Node prev = head;
        Node curr = head.next;
        prev.next = null;
        while(curr != null)
        {
            Node next = curr.next;

            Node prevT = prev;
            Node nextT = next;
            int ans = 0;
            while(prevT != null && nextT != null)
            {
                if(prevT.data == nextT.data)
                {
                    ans++;
                    prevT = prevT.next;
                    nextT = nextT.next;
                }
                else break;
            }
            System.out.println(2 * ans + 1);
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // reverse the list from prev to get back the origi
        head = Reverse.reverse(prev);
        return  head;
    }

    public static void main(String[] args) {
        Node head = NodeUtils.getListFromArr(new int[]{1,2,1,1,1,2,3,2});
        System.out.println("aaa" + new LongestOddPalindrome().solve(head));
    }
}
