/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-09-13 23:32
*/

public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        // do initialize if necessary
    }

    public void push(int number) {
        stack.push(number);
        if(minStack.isEmpty()){
            minStack.push(number);
        }else{
            minStack.push(Math.min(number, minStack.peek()));
        }
        // write your code here
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
        // write your code here
    }

    public int min() {
        return minStack.peek();
        // write your code here
    }
}
