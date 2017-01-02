/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-08-19 22:43
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A==null || A.length == 0){
            return false;
        }
        
        int length = A.length;
        boolean dp[] = new boolean[length];
        dp[0] = true;
        
        for(int i = 1; i < length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && A[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[length - 1];
        
        //č´Şĺż
        
        // int farthest = A[0];
        // int n = A.length;
        
        // for(int i = 1; i < n; i++){
        //     if(i <= farthest && i + A[i] >= farthest){
        //         farthest = i + A[i];
        //     }
        // }
        // return farthest >= n - 1; 
        
    }
}
