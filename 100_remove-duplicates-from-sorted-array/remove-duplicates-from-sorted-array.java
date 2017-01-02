/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 16-11-01 01:39
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[size] != nums[i]){
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}