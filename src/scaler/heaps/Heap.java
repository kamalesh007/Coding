package scaler.heaps;

import java.util.LinkedList;
import java.util.*;

public class Heap <T>{

    public int size;
    public DLNode head;
    public DLNode tail;
    public Heap(){
    }

    public void insertDLNodeTail(T node)
    {
        DLNode temp = new DLNode(node);
        if(head == null)
        {
            this.head = temp;
            this.tail = temp;
        }
        else
        {
            this.tail.next = temp;
            temp.prev = this.tail;
            this.tail = temp;
        }
    }

    public void insertDLNodeHead(T node)
    {
        DLNode temp = new DLNode(node);
        if(head == null)
        {
            this.head = temp;
            this.tail = temp;
        }
        else
        {
            temp.next = this.head;
            this.head.prev = temp;
            this.head = temp;
        }
    }

    public DLNode getMiddle()
    {
        DLNode slow = this.head;
        DLNode fast = this.head;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

class DLNode<T>
{
    public T data;
    public DLNode prev;
    public DLNode next;

    public DLNode(T data)
    {
        this.data = data;
    }
}
