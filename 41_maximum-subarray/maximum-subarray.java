/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-10-16 00:59
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        //int max = Integer.MIN_VALUE, prefixSum = 0, theMinSum = 0;
        // for(int i = 0; i < nums.length; i++){
        //     prefixSum += nums[i];
        //     max = Math.max(max, prefixSum - theMinSum); //以nums[i]结尾的 能达到的最大subarray的和 
        //     theMinSum = Math.min(theMinSum, prefixSum);
        // }
        
        
        /*
        从头开始到nums[i]的和是固定的，只有当某个点前缀和最小，它后半部分和才能最大
        */
        int max = Integer.MIN_VALUE;
        int sum = 0, minSum = 0; // sum: prefix sum; minSum: the minimum prefix sum;
        
        // for(int i = 0; i < nums.length; i++){
        //     sum += nums[i];
        //     max = Math.max(max, sum - minSum);
            
        //     minSum = Math.min(minSum, sum);
        // }
        
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            //left[i] = max;
        }
        
        return max;
    }
}