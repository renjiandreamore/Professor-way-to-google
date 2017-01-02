/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/next-permutation-ii
@Language: Java
@Datetime: 16-10-26 05:30
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        if(nums.length == 1) return;
        //1,2,4,3 --> 1, 3, 2, 4
        
        //find the last increse
        //1,2,4,3 ---- 2
        int index = nums.length; 
        for(int i = nums.length - 2; i>=0 ; i--){
            if(nums[i+1] > nums[i] ){
                index = i;
                break;
            }
        }
        
        if(index == nums.length){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        //find the fisrt > nums[index] after index;
        int right = 0;
        for(int i = nums.length - 1; i>= index; i--){
            if(nums[i] > nums[index]){
                right = i;
                break;
            }
        }
        
        int tmp = nums[index];
        nums[index] = nums[right];
        nums[right] = tmp;
        
        reverse(nums, index + 1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right){
        for(int i = left, j = right; i < j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}