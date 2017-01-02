/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-02-28 22:07
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long start = 1;
        long end = x;
        while(start + 1< end){
            long mid = start + ( end - start)/ 2;
            if(mid * mid <= x){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(start * start <= x){
            return (int)start;
        }else{return (int)end;}
    }
}