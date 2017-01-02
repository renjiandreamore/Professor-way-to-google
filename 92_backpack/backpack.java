/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 16-12-21 20:59
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        
        
        /**
        *  dp[i][j] 表示把前i个物体装入背包容量为j的包时可获得的最大容量
        *  boolean 版本 dp[i][j] 表示前i个物体刚好能装满j容量的背包
        *
        **/
        if(A == null || A.length == 0 || m < 0){
            return 0;
        }
        int n = A.length;
        
        //Arrays.sort(A);
        
        /*
        * boolean 版本
        */
        
        // boolean[][] dp = new boolean[A.length + 1][m+1];
        // dp[0][0] = true;
        
        
        // for(int i = 1; i <= A.length; i++){
        //     for(int j = 0; j <= m; j++){
        //         if(j >= A[i-1]){
        //             dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        
        
        // for(int i = m; i >= 0; i--){
        //     if(dp[A.length][i]){
        //         return i;
        //     }
        // }
        // return 0;
        
        /**
         * int版本
         * 
         **/ 
         
        int[][] dp = new int[n+1][m+1];
        //  for(int i = 0; i < m + 1; i++){
        //      dp[0][i] = 0;
        //  }
         
         int max = 0;
         
         for(int i = 1; i <= n; i++){
             for(int j = 0; j <= m; j++){
                 if(j >= A[i-1]){
                     dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - A[i-1]] + A[i-1]);
                    
                 }else{
                     dp[i][j] = dp[i-1][j];
                 }
                 max = dp[i][j];
             }
         }
         //return max;
         return dp[n][m];
    }
}