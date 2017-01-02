/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 16-10-16 01:04
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        
        if(nums.size() == 0||nums == null){
            return 0;
        }
        //dp from left
        int sum = 0, minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.size();i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        
        //dp from right
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = nums.size() - 1; i>=0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        //add two
        max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size()-1; i++){
           max = Math.max(max, left[i] + right[i+1]) ;
        }
        
        return max;
        
        
    }
}

