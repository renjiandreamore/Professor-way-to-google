/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-03-28 17:51
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int min = Integer.MAX_VALUE, sum = 0;
        for(int i =0; i< nums.size(); i++){
            sum += nums.get(i);
            min = Math.min(min, sum);
            sum = Math.min(0, sum);
        }
        return min;
    }
}
