/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-integer
@Language: Java
@Datetime: 16-11-22 20:29
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        int reversed_digit = 0;
        
        while(n != 0){
            int tmp = reversed_digit * 10 + n % 10;
            n = n / 10;
            if(tmp / 10 != reversed_digit){
                return 0;
            }
            reversed_digit = tmp;
        }
        
        return reversed_digit;
    }
}