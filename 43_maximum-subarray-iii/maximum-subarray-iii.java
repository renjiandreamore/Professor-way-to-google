/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Java
@Datetime: 16-11-15 02:45
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums.length < k) {
            return 0;
        }
        int n = nums.length;
        
        int[][] local = new int[k+1][n+1];
        int[][] global = new int[k+1][n+1];
        
        for(int i = 1; i <= k; i++){
            local[i][i-1] = Integer.MIN_VALUE;
            for(int j = i; j <= n; j++){
                local[i][j] = Math.max(local[i][j-1], global[i-1][j-1]) + nums[j-1];
                //local表示必须要选它最后一个 ，所以可以 表示为最后一个是独立(global)还是和倒数第二个相关(local)  
                if(i == j) global[i][j] = local[i][j];
                else global[i][j] = Math.max(local[i][j], global[i][j-1]);
            }
        }
        return global[k][n];
    }
}
