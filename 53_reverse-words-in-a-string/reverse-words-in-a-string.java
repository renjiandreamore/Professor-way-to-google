/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-words-in-a-string
@Language: Java
@Datetime: 16-10-21 03:35
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0){
            return "";
        }
        String[] words = s.split(" ");
        String res = "";
        for(int i = words.length-1; i >= 0; i--){
            res += words[i] + " ";
        }
        
        return res.trim();
    }
}
