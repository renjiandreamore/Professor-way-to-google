/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/a-b-problem
@Language: Java
@Datetime: 16-03-28 03:33
*/

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        //write your code here, try to do it without arithmetic operators.
        if(a == 0){return b;}
        if(b == 0){return a;}
        
        int x1 = a^b;
        int x2 = (a&b)<<1;
        return aplusb(x1, x2);  //x+y = x-y + 2y
        //return a + b;
    }
};