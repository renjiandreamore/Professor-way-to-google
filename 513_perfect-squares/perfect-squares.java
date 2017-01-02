/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/perfect-squares
@Language: Java
@Datetime: 16-11-17 16:40
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n+1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i * i <= n; i++){
            dp[i*i] = 1;
        }
        
        for(int i = 0; i <=n; i++) {
            for(int j = 0; j * j + i <= n; j++){
                dp[j*j + i] = Math.min(dp[i] + 1, dp[j*j + i]);
            }
        }
        
        return dp[n];
    }
}