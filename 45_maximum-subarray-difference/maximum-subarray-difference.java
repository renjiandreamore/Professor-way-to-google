/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Java
@Datetime: 16-03-28 23:00
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        
        int[] leftmax = new int[nums.length];
        int[] leftmin = new int[nums.length];
        int[] rightmax = new int[nums.length];
        int[] rightmin = new int[nums.length];
        
        //find max from left
        for(int i = 0; i<leftmax.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(0, sum);
            leftmax[i] = max;
        }
        //find min form left:
       
        sum = 0;
        for(int i = 0; i<leftmin.length; i++){
            sum += nums[i];
            min = Math.min(min, sum);
            sum = Math.min(0,sum);
            leftmin[i] = min;
        }
        //find max from right
        sum = 0;
        max = Integer.MIN_VALUE;
        for(int i = nums.length-1; i>=0; i--){
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(0, sum);
            rightmax[i] = max;
        }
        
        //find min from right
        min = Integer.MAX_VALUE;
        sum = 0;
        for(int i = nums.length-1; i >=0; i--){
            sum += nums[i];
            min = Math.min(min, sum);
            sum = Math.min(0, sum);
            rightmin[i] = min;
        }
        
        //count max|A-B|
        int dif = Integer.MIN_VALUE;
        for(int i =0; i< nums.length - 1; i++){
            dif = Math.max(dif, leftmax[i] - rightmin[i+1]);
            
        }
        for(int i = 1; i < nums.length; i++){
            dif = Math.max(dif, rightmax[i] - leftmin[i-1]);
        }
        return dif;
    }
    
}

