/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/wiggle-sort-ii
@Language: Java
@Datetime: 16-12-06 17:29
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length <= 1) return;
        
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n - 1)/2;
        int index = 0;
        
        int[] tmp = new int[n];
        
        for(int i = 0; i <= mid; i++){
            tmp[index] = nums[mid - i];
            if(index + 1 < n){
                tmp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        
        System.arraycopy(tmp, 0, nums, 0, n);
    }
}
