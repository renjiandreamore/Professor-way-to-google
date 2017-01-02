/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-09-14 19:08
*/


import java.util.Random;
class Solution {
    
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        sort1(nums, 0, nums.length-1);
        ArrayList<Integer> ne = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            ne.add(nums[i]);
        }
        
        Collections.reverse(ne);
        
        int[] new1 = new int[k];
        for(int i = 0 ; i < k ; i++){
            new1[i] = ne.get(i);
        }
        return new1;
        
        //用heap再写一遍
        
        
        
    }
    
    public void sort1(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int left = start, right = end;
        
        int pivot = nums[(left+right)/2];
        
        while(left <= right){
            while(left<=right && nums[left] < pivot){
                left++;
            }
            while(left<=right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        
        sort1(nums, start, right);
        sort1(nums, left, end);
    }
};

