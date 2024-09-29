package Learnings.NestedClasses;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList <T>{

    private static class Node<K>
    {
        K data;
        Node<K> next;

        public Node(K data)
        {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyArrayList() throws Exception
    {
    }

    public void add(T element)
    {
        if(this.head == null)
        {
            this.head = new Node<>(element);
            this.tail = this.head;
        }
        else
        {
            this.tail.next = new Node<>(element);
            this.tail = this.tail.next;
        }
        size++;
    }

    public T removeFirst()
    {
        if(this.head == null)
        {
            return null;
        }
        else
        {
            T ele = this.head.data;
            this.head = this.head.next;
            if(this.head == null)
            {
                this.tail = null;
            }
            size --;
            return ele;
        }
    }

    public java.util.Iterator<T> iterator()
    {
        return new Itr();
    }

    private class Itr implements java.util.Iterator<T>
    {
        private Node<T> cursor;

        public Itr()
        {
            cursor = MyArrayList.this.head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if(cursor == null)
                throw new RuntimeException();
            else
            {
                T element = cursor.data;
                cursor = cursor.next;
                return element;
            }
        }
    }
}
