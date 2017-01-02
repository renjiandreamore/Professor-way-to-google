/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-10-26 17:18
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if(n <= 0) return false;
        // write your code here
        // double x =  (Math.log((double) n) / Math.log((double) 2));
        // int y = (int) x;
        // if(x == y ) return true;
        // else return false;
        
        if( (n & (n-1)) == 0){
            return true;
        }else{
            return false;
        }
    }
};