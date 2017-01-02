/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 16-04-02 20:57
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
      while(i <= right){
        if(nums[i] == 1){
            i++;
        }else if(nums[i]==0){
            swap(nums, left, i);
            i++;
            left++;
        }else{
            swap(nums, i , right);
            right --;
            
        }
        
        
      } 

    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}