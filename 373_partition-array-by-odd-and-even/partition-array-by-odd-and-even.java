/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 16-11-08 04:49
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int i = 0, j = nums.length - 1;
        
        while(i < j){
            if(nums[i] % 2 == 1){
                i++;
                
            }
            else if(nums[j] % 2 == 0){
                j--;
            }
            else {
                int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
            }
        }
    }
}