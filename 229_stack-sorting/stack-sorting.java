/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-10-05 00:59
*/

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        /*
        栈排序的关键，在于（题目给出最大的在top), 每次从顶向下走
        遇到不是顺序减小的第一个值，比如 98453 的 5， pop出来，把它调整加入到正确位置 98 5 4（984是在临时tmp栈里，然后再取回来的）， 3 还在原来的stack里
        */
        
        if(stack == null){
            return;
        }
        
        Stack<Integer> tmp = new Stack<>();
        
        while(!stack.isEmpty()){
           if(tmp.isEmpty() || tmp.peek() >= stack.peek()){
                tmp.push(stack.pop());
                //stack.pop();
            } 
            
            else{
                int val = stack.pop();
                while( !tmp.isEmpty() && tmp.peek() <= val){
                    stack.push(tmp.pop());
                   // tmp.pop();
                }
                stack.push(val);
                
                while(!tmp.isEmpty()){
                    stack.push(tmp.pop());
                    //tmp.pop();
                }
            }
        }
        
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
            //tmp.pop();
        }
        
    }
}