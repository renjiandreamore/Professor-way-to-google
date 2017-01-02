/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-10-24 01:19
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        /**
         * 找到最后一次增长的位置i（表示其后都为下降） （意味着要在这个点改变数值）（改变的则是其后下降的数值里第一个比他大的值）
		于是找到它后面第一个比他大的值，二者交换
		（此时交换后的i的地方放了正确的值）， 可是其后还是从大到小逐一减少。但是按理来说，交换以后，其后部正好应该从小到大，于是reverse一下就可以了。
         *   [2,4,3,1]
         */ 
         
         if(nums == null || nums.length == 0){
             return nums;
         }
         int l = nums.length;
         
         int lastIncrs = -1;
         for(int i = l - 2; i >=0; i--){
             if(nums[i+1] > nums[i]){
                 lastIncrs = i;
                 break;
             }
         }
         
         if(lastIncrs == -1){
             return reverse(nums, 0, l - 1);
         }
         
         int smallestLarger = lastIncrs + 1;
         for(int i = l -1; i >= smallestLarger; i--){
             if(nums[i] > nums[lastIncrs]){
                 smallestLarger = i;
                 break;
             }
         }
         
         int tmp = nums[lastIncrs];
         nums[lastIncrs] = nums[smallestLarger];
         nums[smallestLarger] = tmp;
         
         return reverse(nums, lastIncrs + 1, l - 1);
    }
    
    public int[] reverse(int[] nums, int a, int b){
        for(int i = a, j = b; i < j; i++, j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}