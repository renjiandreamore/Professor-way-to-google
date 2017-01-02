/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/house-robber-ii
@Language: Java
@Datetime: 16-11-27 21:22
*/

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        
        if(n == 1){
            return nums[0];
        }
        
        return Math.max(rob1(nums, 0, n - 2), rob1(nums, 1, n - 1));
    }
    
    public int rob1(int[] A, int start, int end){
        
        int n = A.length;
        int[] dp = new int[n+1];
        
        dp[start] = 0;
        dp[start+1] = A[start];
        
        for(int i = start + 1; i <= end; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + A[i]);
        }
        
        return dp[end + 1];
    }
}