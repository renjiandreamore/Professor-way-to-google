/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-08-19 23:56
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        
        for(int j = 0; j < m; j++){
            if(obstacleGrid[0][j] == 0){
                dp[0][j] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[n - 1][m - 1];
        
    }
}