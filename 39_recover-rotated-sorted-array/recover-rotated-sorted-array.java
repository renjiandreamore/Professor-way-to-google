/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 16-10-21 15:04
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) return;
        
        int n = nums.size();
        int pos = 0;
        for(int i = 0; i < n-1; i++){
            if(nums.get(i) > nums.get(i+1)){
                pos = i + 1; 
                break;
            }
        }
        
        //if(pos == 0) return;
        
        reverse(nums, 0, pos - 1);
        reverse(nums, pos, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
}