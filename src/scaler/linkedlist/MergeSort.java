package scaler.linkedlist;

public class MergeSort {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        three.next = two;
        two.next = one;
        System.out.println(new MergeSort().sort(three));
    }

    public Node sort(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node mid = getMid(head);
        Node h1 = head;
        Node h2 = mid.next;
        mid.next = null;
        h1 = sort(h1);
        h2 = sort(h2);

        return merge(h1,h2);
    }

    public Node merge(Node h1,Node h2)
    {
        if(h1 == null ) return h2;
        if(h2 == null ) return h1;

        Node head = null;
        if(h1.data < h2.data)
        {
            head = h1;
            h1 = h1.next;
        }
        else
        {
            head = h2;
            h2 = h2.next;
        }

        Node temp = head;
        while(h1 != null && h2 != null)
        {
            if(h1.data < h2.data)
            {
                temp.next = h1;
                h1 = h1.next;
            }
            else
            {
                temp.next = h2;
                h2 = h2.next;
            }

            temp = temp.next;
        }
        if(h1 != null) temp.next = h1;
        if(h2 != null) temp.next = h2;
        return head;
    }

    public Node getMid(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
