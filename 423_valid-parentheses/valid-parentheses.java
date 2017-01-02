/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/valid-parentheses
@Language: Java
@Datetime: 16-12-01 04:23
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s == null || s.length() == 0 || s.length() == 1) return false;
        
        // HashSet<String> set = new HashSet<>();
        // set.add("()");
        // set.add("[]");
        // set.add("{}");
        
        // for(int i = 0; i <= s.length()-2; i+=2){
        //     if(!set.contains(s.substring(i,i+2))){
        //         return false;
        //     }
        // }
        
        // return true;
        
        Stack<Character> st = new Stack<>();
        
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if("({[".contains(String.valueOf(ch[i]))){
                st.push(ch[i]);
            }else{
                if(!st.isEmpty() && match(st.peek(), ch[i])){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
    
    public boolean match(char c1, char c2){
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}