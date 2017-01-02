/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/ugly-number
@Language: Java
@Datetime: 16-11-24 23:16
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        if(num <= 0) return false;
        //if(num == 1) return true;
        
        while(num > 0){
            if(num % 2 == 0){
                num = num / 2;
                continue;
            }
            if(num % 3 == 0){
                num = num / 3;
                continue;
            }
            if(num % 5 == 0){
                num = num / 5;
                continue;
            }
            return num == 1;
        }
        
        return false;
        
        
    }
}