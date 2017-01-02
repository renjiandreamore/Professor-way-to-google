/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-stack
@Language: Java
@Datetime: 16-10-04 18:44
*/

class Stack {
    
    ArrayList<Integer> stack = new ArrayList<>();
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        stack.add(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        int n = stack.size();
        stack.remove(n-1);
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int n = stack.size();
        return stack.get(n-1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return stack.size() == 0;
    }    
}