/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/wiggle-sort
@Language: Java
@Datetime: 16-12-06 06:22
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length <= 1) return;
        
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 1 && nums[i] <= nums[i-1] || i%2 == 0 && nums[i] >= nums[i-1]){
                swap(nums, i, i-1);
            }
        }
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}