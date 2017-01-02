/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-04-02 20:03
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    int i = 0;
	    int j = nums.length - 1;
	    
	    for(i = 0; i <= j; i++){
	        if(nums[i] < k){
	            continue;
	        }
	        
	        while(i <= j && nums[j] >= k){
	            j--;
	        }
	        
	        if(j >= 0 && i<j){
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            j--;
	        }
	    }
	    return j + 1;
    }
}