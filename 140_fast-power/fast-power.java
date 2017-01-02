/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 16-10-26 18:11
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0) return 1 % b;
        if(n == 1) return a % b;
        
        long half = fastPower(a,b, n / 2);
        long rst = (half * half) % b;
        if(n % 2 == 1){
            rst = (rst * (a%b) ) % b;
        }
        
        return (int) rst;
    }
};