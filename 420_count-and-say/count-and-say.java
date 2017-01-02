/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/count-and-say
@Language: Java
@Datetime: 16-12-16 02:34
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        String oldString = "1";
        while(n > 1){
            char[] ch = oldString.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < ch.length; i++){
                int count = 1;
                while((i + 1)<ch.length && ch[i] == ch[i+1]){
                    count ++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(ch[i]));
            }
            oldString = sb.toString();
            n--;
        }
        
        return oldString;
    }
}