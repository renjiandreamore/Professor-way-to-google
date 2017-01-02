/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/expression-expand
@Language: Java
@Datetime: 16-12-06 22:16
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if(s == null || s.length() == 0) return s;
        
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        
        int number = 0;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = number * 10 + c - '0'; //Integer.parseInt(String.valueOf(c));
            }else if(c == '['){
                str.push(String.valueOf(c));
                num.push(number);
                number=0;
            }else if(c == ']'){
                Stack<String> tmp = new Stack<>();
                while(!str.isEmpty()){
                    String top = str.pop();
                    if(top.equals("[")){
                        StringBuilder sb = new StringBuilder();
                        StringBuilder res = new StringBuilder();
                        while(!tmp.isEmpty()){
                            sb.append(tmp.pop());
                        }
                        
                        int times = num.pop();
                        for(int i = 0; i < times; i++){
                            res.append(sb.toString());
                        }
                        str.push(res.toString());
                        break;
                    }
                    tmp.push(top);
                }
            }else{
                str.push(String.valueOf(c));
            }
        }
        
        Stack<String> reverse = new Stack<>();
        while(!str.isEmpty()){
            reverse.push(str.pop());
        }
        
        StringBuffer sb = new StringBuffer();
        while(!reverse.isEmpty()){
            sb.append(reverse.pop());
        }
        
        return sb.toString();
    }
}