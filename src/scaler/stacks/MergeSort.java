package scaler.stacks;

import scaler.linkedlist.Node;
import scaler.linkedlist.NodeUtils;
import scaler.linkedlist.Reverse;

public class MergeSort {

    public StackImpl mergeSort(StackImpl stack)
    {
        if(stack.isEmpty()) // no element
        {
            return null;
        }
        else
        {
            Node mid = NodeUtils.getMid(stack.top);
            if(stack.peek() == mid)
            {
                return stack;
            }
            StackImpl left = new StackImpl();
            while(!stack.isEmpty() && stack.peek() != mid)
            {
                left.push(stack.pop());
            }
            StackImpl right = stack;

            left = mergeSort(left);
            right = mergeSort(right);
            StackImpl merged = merge(left,right);
            return merged;
        }
    }

    public StackImpl merge(StackImpl first,StackImpl second)
    {
        if(first == null) return second;
        if(second == null) return first;


        Node left = first.top;
        Node right = second.top;

        Node head = null;
        if(left.data < right.data)
        {
            head = left;
            left = left.next;
        }
        else
        {
            head = right;
            right = right.next;
        }

        Node temp = head;
        while(left != null && right!= null)
        {
            if(left.data < right.data)
            {
                temp.next = left;
                left = left.next;
            }
            else
            {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if(left!= null) temp.next = left;
        if(right != null) temp.next = right;
        head = Reverse.reverse(head);
        temp = head;
        StackImpl stack = new StackImpl();
        while( temp != null)
        {
            Node next = temp.next;
            stack.push(temp);
            temp = next;
        }

        return stack;
    }


    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(3);
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(6);

        stack = new scaler.stacks.MergeSort().mergeSort(stack);

        System.out.println(stack);

    }
}
