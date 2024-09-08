package scaler.stacks;

import scaler.linkedlist.Node;

public class StackImpl {

    Node top;

    public void push(Node element)
    {
        if(this.top == null)
        {
            element.next = null;
            this.top = element;
        }

        else
        {
            element.next = null;
            element.next = this.top;
            this.top = element;
        }
    }

    public void push(int element)
    {
        if(this.top == null)
            this.top = new Node(element);
        else
        {
            Node current = new Node(element);
            current.next = this.top;
            this.top = current;
        }
    }

    public Node pop()
    {
        if(this.top == null) return null;
        else
        {
            Node toReturn = this.top;
            this.top = this.top.next;
            toReturn.next = null;
            return toReturn;
        }
    }

    public Node peek()
    {
        if(this.top == null) return null;
        else return this.top;
    }

    public boolean isEmpty()
    {
        return this.top == null;
    }

    public String toString()
    {

        String out = "";
        Node head = this.top;
        while (head != null)
        {
            out += head.data +"\t";
            head = head.next;
        }
        return out;
    }
}
