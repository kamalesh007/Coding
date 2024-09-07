package scaler.linkedlist;

public class NodeUtils {

    public static Node getListFromArr(int[] arr)
    {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i < arr.length ; i++)
        {
            Node ele = new Node(arr[i]);
            temp.next = ele;
            temp = temp.next;
        }
        return head;

    }
}
