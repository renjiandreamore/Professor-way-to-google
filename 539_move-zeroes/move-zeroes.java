/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 16-12-22 16:38
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0) return;
        
        int i = 0, j = 0;
        // while(i < nums.length && j < nums.length){
        //     while(i < nums.length && nums[i] != 0) i++;
        //     j = i+1;
        //     while(j < nums.length && nums[j] == 0) j++;
        //     if(i >= nums.length || j >= nums.length) return;
            
        //     swap(i, j, nums);
        //     i++;
        //     j++;
        // }
        while(j < nums.length){
            if(nums[j] != 0){
                swap(i,j,nums);
                i++;
            }
            j++;
        }
        
    }
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}