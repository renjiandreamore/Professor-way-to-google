/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-04-17 18:59
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        //top - down
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        //初始化
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        //dp
        for(int i = 0; i < n; i++){
            for(int j = 1; j < i; j++ ){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        //找最后一行最小的那个.
        int best = dp[n-1][0];
        for(int i = 1; i < n; i++){
            best = Math.min(best, dp[n-1][i]);
        }
        return best;
        
    }
}
