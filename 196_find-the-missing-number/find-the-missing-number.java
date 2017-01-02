/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-the-missing-number
@Language: Java
@Datetime: 16-10-05 17:46
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int i = 0;
        int n = nums.length;
        
        while(i < n){
            while(i != nums[i] && nums[i] != n){
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            } //把数组当前位置的值 f[i] 和 当面位置值当做下标的值f[f[i]]，交换
            i++;
        }
        
        for(int j = 0; j < n; j++){
            if(j != nums[j]){
                return j;
            }
        }
        
        return n;
    }
}