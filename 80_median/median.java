/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 16-10-23 01:15
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        if(nums.length % 2 == 0)
            return nums[nums.length / 2 - 1];
        else 
            return nums[nums.length/2];
    }
}
