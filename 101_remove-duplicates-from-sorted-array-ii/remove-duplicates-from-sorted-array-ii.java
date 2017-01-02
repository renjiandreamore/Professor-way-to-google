/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii
@Language: Java
@Datetime: 16-11-01 02:08
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = 0;
        int i, j;
        
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for(j = i; j < nums.length; j++){
                if(nums[j] != nums[i]) break;
                if(j-i < 2){
                    nums[cur++] = now;
                }
            }
            i = j;
        }
        
        return cur ;
        
        
    }
}