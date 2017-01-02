/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/length-of-last-word
@Language: Java
@Datetime: 16-02-28 20:25
*/

public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        int length = 0;
        char[] chars = s.toCharArray();
        
        for(int i = chars.length -1; i >= 0; i--){
            if(length == 0){
                if(chars[i] == ' '){
                    continue;
                }else{
                    length ++;
                }
            }else if(length != 0){
                if(chars[i] == ' '){
                    break;
                }else{
                    length ++;
                }
            }
        }
        return length;
    }
}