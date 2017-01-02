/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Java
@Datetime: 16-11-09 18:48
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        //maintain a window
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int i=0, j =0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(i =0;i<nums.length;i++){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >= s){
                ans = Math.min(ans, j - i);
            }
            sum = sum - nums[i];
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        
        return ans;
    }
}