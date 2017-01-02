/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/climbing-stairs-ii
@Language: Java
@Datetime: 16-09-29 14:29
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        if(n <= 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 3; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] ;
        }
        
        return dp[n-1];
    }
}