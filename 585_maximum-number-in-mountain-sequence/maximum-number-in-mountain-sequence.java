/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-number-in-mountain-sequence
@Language: Java
@Datetime: 16-12-14 23:57
*/

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        // int max = Integer.MIN_VALUE;
        // for(int i : nums){
        //     max = Math.max(i, max);
        // }
        
        // return max;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = (start + end)/2;
            if(nums[mid] < nums[mid - 1]){
                end = mid;
            }else if(nums[mid] < nums[mid+1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(nums[start] > nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}