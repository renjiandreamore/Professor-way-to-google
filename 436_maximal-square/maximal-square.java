/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximal-square
@Language: Java
@Datetime: 16-11-17 14:51
*/

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
     
     //dp[i][j]以ij为正方形右下角 
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int ans = 0;
        
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
            ans = Math.max(ans, dp[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
            ans = Math.max(ans, dp[0][i]);
        }
        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i -1][j - 1]), dp[i - 1][j]) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans * ans;
    }
}