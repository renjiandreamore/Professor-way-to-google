/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Java
@Datetime: 16-04-17 23:56
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        if(m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        
        //initialize
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
