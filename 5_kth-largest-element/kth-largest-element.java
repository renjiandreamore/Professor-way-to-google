/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 16-10-21 14:29
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code herea
        if(nums == null || nums.length == 0 || k <= 0){
            return 0;
        }
        
        int n = nums.length;
        sort(nums, 0, n-1);
        return nums[n-k];
        
    }
    
    public void sort(int[] nums, int left, int right){
        if(left >=right){
            return;
        }
        int start = left;
        int end = right;
        int pivot = nums[(left + right)/2];
        
        while(start <= end){
            while(start <= end && nums[start] < pivot) start++;
            while(start <= end && nums[end] > pivot) end--;
            if(start <= end){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                
                start++;
                end--;
            }
        }
        
        sort(nums, left, end);
        sort(nums, start, right);
    }
};