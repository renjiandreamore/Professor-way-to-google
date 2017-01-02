/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/two-sum-closest
@Language: Java
@Datetime: 16-09-13 23:00
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        
        int i = 0, j = nums.length - 1;
        
        int dif = Integer.MAX_VALUE;
        while(i < j){
            if(target-(nums[i] + nums[j]) > 0){
                if(target-(nums[i] + nums[j]) < dif){
                    dif = target-(nums[i] + nums[j]);
                }
                i++;
            }else{
                if((nums[i] + nums[j]) - target < dif){
                    dif = (nums[i] + nums[j]) - target;
                }
                j--;
            }
        }
        return dif;
    }
}