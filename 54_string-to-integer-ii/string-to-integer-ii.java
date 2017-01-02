/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-10-24 19:38
*/

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0 ){
            return 0;
        }
        
        str = str.trim();
        int sign = 1;
        int index = 0;
        
        if(str.charAt(0) == '+') index ++;
        else if(str.charAt(0) == '-'){
            sign = -1;
            index ++;
        }
        
        long res = 0;
        for(;index < str.length();index++){ //也可以写成 for(index = index;...) 
            if(str.charAt(index) < '0' || str.charAt(index) > '9'){
                break;
            }
            
            res = res * 10 + (str.charAt(index) - '0');
            if(res > Integer.MAX_VALUE) break;
        }
        
        if(res * sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(res * sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)res * sign;
    }
}