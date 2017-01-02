/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 16-12-21 19:40
*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask = (j < 31 ? ~((1 << (j + 1)) - (1 << i)) : ((1 << i) - 1));
        return  (mask & n) + (m << i);
    }
}
