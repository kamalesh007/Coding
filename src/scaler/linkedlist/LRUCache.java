package scaler.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private int len;

    private Map<Integer,LRUNode> cache;

    LRUNode head;

    LRUNode tail;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.len = 0;
    }

    public void swap(LRUNode node)
    {
        if(this.tail == node) return;
        else if(this.head == node)
        {
            LRUNode temp = node;
            this.head = this.head.next;
            this.head.prev = null;
            temp.prev = this.tail;
            temp.next = null;
            this.tail.next = temp;
            this.tail = this.tail.next;
        }
        else
        {
            LRUNode temp = node;
            LRUNode prev = temp.prev;
            LRUNode next = temp.next;

            prev.next = next;
            next.prev = prev;

            temp.prev = tail;
            temp.next = null;
            this.tail.next = temp;
            this.tail = this.tail.next;
        }
    }

    public int get(int key)
    {
        if(cache.containsKey(key))
        {
            swap(cache.get(key));
            return this.tail.value;
        }
        return -1;
    }

    public void remove()
    {
        cache.remove(this.head.key);
        this.head = this.head.next;
        if(this.head == null)
        {
            this.tail = null;
        }
        else
        {
            this.head.prev = null;
        }
    }

    public void set(int key,int value)
    {
        if(cache.containsKey(key))
        {
            LRUNode current = cache.get(key);
            current.value = value;
            swap(current);
        }
        else
        {
            if(this.len < this.capacity)
            {
                LRUNode current = new LRUNode(key,value);
                cache.put(key,current);
                if(this.head == null)
                {
                    this.head = current;
                    this.tail =current;
                }
                else
                {
                    current.prev = this.tail;
                    this.tail.next = current;
                    this.tail = current;
                }
                this.len++;
            }
            else
            {
                remove();
                LRUNode current = new LRUNode(key,value);
                cache.put(key,current);
                if(this.head == null)
                {
                    this.head = current;
                    this.tail = current;
                }
                else
                {
                    current.prev = this.tail;
                    this.tail.next = current;
                    this.tail = current;
                }
            }
        }
    }
}
class LRUNode
{
    int key,value;
    LRUNode next;
    LRUNode prev;

    public LRUNode(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
}
