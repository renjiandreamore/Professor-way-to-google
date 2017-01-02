/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/coins-in-a-line
@Language: Java
@Datetime: 16-11-17 19:56
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean[] dp = new boolean[n];
        if(n == 0) return false;
        if(n < 2) return true;
        
        dp[0] = true;
        dp[1] = true;
        
        for(int i = 2; i < n; i++){
            if(dp[i-1] && dp[i - 2]){
                dp[i] = false;
            }else
                dp[i] = (dp[i-1] || dp[i-2]);
        }
        
        return dp[n-1];
    }
}