package scaler.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node
{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString()
    {
        List<Integer> arr = new ArrayList<>();
        Node temp = this;
        while(temp != null)
        {
            arr.add(temp.data);
            temp = temp.next;
        }
        return arr.stream().map(Object::toString)
                .collect(Collectors.joining("--->"));
    }
}