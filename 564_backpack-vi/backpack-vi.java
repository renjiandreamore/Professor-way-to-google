/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/backpack-vi
@Language: Java
@Datetime: 16-12-22 02:48
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i < target + 1; i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        
        return dp[target];
    }
}