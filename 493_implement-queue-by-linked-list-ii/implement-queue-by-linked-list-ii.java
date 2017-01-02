/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list-ii
@Language: Java
@Datetime: 16-10-05 02:01
*/

public class Dequeue {
    
    Node first, last;
    
    public Dequeue() {
        // do initialize if necessary
        first = last  = null;
    }

    public void push_front(int item) {
        // Write your code here
        if(first == null){
            first = last = new Node(item);
        }else{
            Node tmp = new Node(item);
            tmp.next = first;
            first.prev = tmp;
            first = tmp;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if(first == null){
            first = last = new Node(item);
        }else{
            Node tmp = new Node(item);
            last.next = tmp;
            tmp.prev = last;
            last = tmp;
        }
    }

    public int pop_front() {
        // Write your code here
        if(first == null){
            return -1;
        }
        else{
            int val = first.val;
            first = first.next;
            if(first != null){
                first.prev = null;
            }else{
                last = null;
            }
            //first.prev = null;
            return val;
        }
        
    }

    public int pop_back() {
        // Write your code here
        if(last == null){
            return -1;
        }
        else{
            int val = last.val;
            last = last.prev;
            if(last!=null){
                last.next = null;
            }else{
                first = null;
            }
            
            return val;
        }
        
    }
}

class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val = val;
        this.next = this.prev = null;
    }
}