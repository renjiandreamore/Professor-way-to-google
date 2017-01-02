/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 16-10-21 02:52
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
        有几个5多几个0 
     */
    public long trailingZeros(long n) {
        // write your code here
        long sum = 0;
        while(n != 0){
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }
};
