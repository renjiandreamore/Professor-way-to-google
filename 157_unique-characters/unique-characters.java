/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/unique-characters
@Language: Java
@Datetime: 16-10-26 01:19
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null || str.length()==0 ) {
            return true;
        }
        
        boolean[] b = new boolean[256];
        for(int i = 0; i < str.length();i++ ) {
            if(b[str.charAt(i)]){
                return false;
            }
            b[str.charAt(i)] = true;
        }
        return true;
    }
}