package scaler.linkedlist;

import java.util.List;

public class Reverse {

    public static Node reverse(Node head)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        node.next = two;
        two.next = three;

        System.out.println(reverse(node));

    }

}
