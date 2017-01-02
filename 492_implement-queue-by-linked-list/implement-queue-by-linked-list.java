/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-10-04 21:10
*/

// public class Queue {
//     public LinkedList<Integer> q;
    
//     public Queue() {
//         // do initialize if necessary
//         q = new LinkedList<Integer>();
//     }

//     public void enqueue(int item) {
//         // Write your code here
//         q.add(item);
//     }

//     public int dequeue() {
//         // Write your code here
//         return q.poll();
//     }
// }
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class Queue {
    public ListNode first, last;
    
    public Queue() {
        // do initialize if necessary
        first = last = null;
    }

    public void enqueue(int item) {
        // Write your code here
        if(first == null){
            last = new ListNode(item);
            first = last;
        }else{
            last.next = new ListNode(item);
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if(first != null){
            int value = first.val;
            first = first.next;
            return value;
        }
        return -1;
    }
}