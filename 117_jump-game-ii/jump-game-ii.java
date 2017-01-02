/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-08-19 22:54
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int n = A.length;
        int[] dp = new int[n];
        
        
        
        dp[0] = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                dp[i] = Integer.MAX_VALUE;
                if(dp[j]!=Integer.MAX_VALUE && j + A[j] >= i){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}







// dp[0] = 0;
        
        // for(int i = 1; i <n; i++){
        //     for(int j = 0; j < i; j++){
        //         dp[i] = Integer.MAX_VALUE;
        //         if(dp[j]!= Integer.MAX_VALUE && j + A[j] >= i){
        //             dp[i] = dp[j] + 1;
        //             break;
        //         }
        //     }
        // }
        // return dp[n-1];