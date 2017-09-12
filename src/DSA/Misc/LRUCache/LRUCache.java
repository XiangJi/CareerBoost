package DSA.Misc.LRUCache;

import java.util.HashMap;

public class LRUCache {
    // inner class
    /*
     *  为什么要使用内部类？在《Think in java》中有这样一句话：使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
     *  在我们程序设计中有时候会存在一些使用接口很难解决的问题，这个时候我们可以利用内部类提供的、可以继承多个具体的或者抽象的类的能力来解决这些程序设计问题。
     *  可以这样说，接口只是解决了部分问题，而内部类使得多重继承的解决方案变得更加完整。
     */
    public class Node{
        Node prev;
        Node next; 
        int key;
        int value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    
    // two dummy node
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // change order 1: remove current from the middle, change pointers
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        // move current to the tail
        moveToTail(current);
        // return
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if( get(key) != -1) {
            map.get(key).value = value; // if already exist, update value
            return;
        }
        
        // if full, remove from head
        if (map.size() >= capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        // then insert
        Node current = new Node(key, value);
        map.put(key, current);
        moveToTail(current); // update as newest
    }
    
    // move one node to the node just before the tail, tail is a dummy node.
    private void moveToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */