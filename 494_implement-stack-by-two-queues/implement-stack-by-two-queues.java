/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 16-09-14 22:06
*/

class Stack {
    
    // Push a new item into the stack
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public Stack(){
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    public void move(){
        while(q1.size() != 1){
            q2.offer(q1.poll());
        }
    }
    
    public void swap(){
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public void push(int x) {
        // Write your code here
        q1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        move();
        q1.poll();
        swap();
        
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        move();
        int item = q1.poll();
        swap();
        q1.offer(item);
        return item;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }    
}