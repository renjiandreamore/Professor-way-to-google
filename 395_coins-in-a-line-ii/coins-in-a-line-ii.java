/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-ii
@Language: Java
@Datetime: 16-11-20 20:18
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        //[1,2,3,4,5]
        //dp[i] dpi 表示 第一个人从第i个数开始取，
        //到游戏结束（取到没有），这个人能获得的最大值
        
        if(values == null || values.length == 0) return false;
        
        if(values.length < 3) return true;
        
        int l = values.length;
        int[] dp = new int[l+1];
        
        int sum = 0;
        for(int i : values){
            sum += i;
        }
        
        dp[l] = 0;
        dp[l-1] = values[l-1];
        dp[l-2] = values[l-1] + values[l-2];
        dp[l-3] = values[l-2] + values[l-3];
        
        
        for(int i = l - 4; i >= 0; i--) {
            int dp1 = values[i] + Math.min(dp[i+2], dp[i+3]);
            int dp2 = values[i] + values[i+1] + Math.min(dp[i+3],dp[i+4]);
            dp[i] = Math.max(dp1, dp2);
        }
        
        
        
        return dp[0] > sum - dp[0];
    }
}