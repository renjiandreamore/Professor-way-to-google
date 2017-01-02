/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/burst-balloons
@Language: Java
@Datetime: 16-04-08 02:46
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[][] visit = new int[n+2][n+2];
        int[] arr = new int[n+2];
        for(int i = 1; i <=n; i++){
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        
        return DPsearch(arr, dp, visit, 1, n);
    }
    
    public int DPsearch(int[] arr, int[][]dp, int[][]visit, int left, int right){
        if(visit[left][right] == 1){
            return dp[left][right];         //为了让代码更快，提高时间
        }
        
        int res = 0;
        for(int k = left; k<= right; k++){
            int leftValue = DPsearch(arr, dp, visit, left, k-1);
            int rightValue = DPsearch(arr, dp, visit, k+1, right);
            int midValue = arr[k]*arr[left-1]*arr[right+1];
            res = Math.max(res, leftValue + midValue+ rightValue);
        }
        visit[left][right] = 1;
        dp[left][right] = res;
        
        return res;
        
    }
}
