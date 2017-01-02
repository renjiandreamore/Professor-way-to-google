/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/house-robber
@Language: Java
@Datetime: 16-11-27 20:59
*/

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        //
        if(A == null || A.length == 0) return 0;
        
        int n = A.length;
        long[] dp = new long[n + 1];
        
        dp[0] = 0;
        dp[1] = A[0];
        
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i-1]);
        }
        
        return dp[n];
    }
}