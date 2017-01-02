/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/divide-two-integers
@Language: Java
@Datetime: 16-11-22 21:06
*/

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor == 0){
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if(dividend == 0) return 0;
        
        boolean isNegtive = (dividend < 0 && divisor >0 ) || (dividend > 0 && divisor < 0);
        
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        
        while( a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift ++;
            }
            
            a = a - (b << (shift -1));
            res = res + (1 << (shift - 1));
        }
        
        return isNegtive ? -res : res;
    }
}