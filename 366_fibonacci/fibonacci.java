/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 16-10-25 18:35
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n <= 0) return -1;
        
        int[] f = new int[1000];
        f[0] = -1;
        f[1] = 0;
        f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }
}

