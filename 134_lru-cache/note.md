```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/lru-cache
@Language: Markdown
@Datetime: 16-09-21 00:46
```

class Node{
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value){
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
}

public class Solution {
    
    
    /*
    hashmap就可以，但是需要在set里统计是否到达capacity
    if true， 那就要从get里记录最少使用的那个key，
    然后删除，可以用priorityqueue
    
    ❌！这个描述是LFU，最近最少使用(统计次数)，而不是LRU，最长时间未被使用（统计最久未被访问的时间！）!!
    
    *1：！一个key可以对应多个value，所以不能从value里找回key，pq不可取！
    *2：！
    */
    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);
    
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    //Queue<Integer> q = new PriorityQueue<Integer>();

    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public void insertBeforeTail(Node current){
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
    
    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)){
            return -1;
        }
        /*
        说明有人使用了它，它是最新被使用的，放在list队尾
        */
        //remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        //move to last
        insertBeforeTail(current);
        
        return map.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        if(map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insertNode = new Node(key, value);
        map.put(key, insertNode);
        insertBeforeTail(insertNode);
        
    }
}