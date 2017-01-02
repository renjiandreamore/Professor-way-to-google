/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-10-05 17:34
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        /*
        max min 为以当前nums[i] 为结尾的乘积的最大最小
        */
        int n = nums.length;
        
        int[] max = new int[n];
        int[] min = new int[n];
        
        max[0] = min[0] = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < n; i++){
            max[i] = min[i] = nums[i];
            if(nums[i] > 0){
                max[i] = Math.max(max[i], max[i-1] * nums[i]);
                min[i] = Math.min(min[i], min[i-1] * nums[i]);
            }else if(nums[i] < 0){
                max[i] = Math.max(max[i], min[i-1] * nums[i]);
                min[i] = Math.min(min[i], max[i-1] * nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}