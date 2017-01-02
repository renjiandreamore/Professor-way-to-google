/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 16-09-14 21:33
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
       // do initialization if necessary
    }
    private void stack2stack(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if(stack2.isEmpty()){
            stack2stack();
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(stack2.isEmpty()){
            stack2stack();
        }
        return stack2.peek();
    }
}