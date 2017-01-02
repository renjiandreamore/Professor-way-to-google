/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 16-11-23 21:04
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s == null || s.length()==0 ) return true;
        
        int i = 0;
        int j = s.length()-1;
        
        while(i < j){
            while(i < s.length() && !isValidChar(s.charAt(i))){
                i++;
            }
            
            if(i == s.length()) return true;
            
            while(!isValidChar(s.charAt(j))){
                j--;
            }
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }else{
                i++;
                j--;
            }
        }
        
        //return true;  
        return j<=i;
    }
    
    public boolean isValidChar(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }
}