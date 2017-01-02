/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-12-16 01:06
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int n = nums.length;
        
    //     int[] firstLarge = new int[n+1];
    //     firstLarge[0] = -1;
        
    //     for(int i = 1; i <= n; i++){
    //         firstLarge[i] = Integer.MAX_VALUE;
    //     }
        
    //     for(int i = 0; i < n; i++){
    //         int index = bsearch(firstLarge, nums[i]);
    //         firstLarge[index] = nums[i]; //找第一个比nums[i]大的位置，有下降就不要了，只看是不是在上升.
    //     }
        
    //     for(int i = n; i >= 1; i--){
    //         if(firstLarge[i] != Integer.MAX_VALUE){
    //             return i;
    //         }
    //     }
    //     return 0; 
        
    // }
    // int bsearch(int[] array, int target){
    //     int start = 0, end = array.length - 1;
    //     while(start + 1 < end){
    //         int mid = (start + end)/2;
    //         if(array[mid] < target){
    //             start = mid;
    //         }else {
    //             end = mid;
    //         }
    //     }
    //     if(array[start] > target){
    //         return start;
    //     }
    //     return end;
    // }
    
    int[] dp = new int[n];
    int mx = 0;
    for(int i = 0; i < n; i++){
        dp[i] = 1;
    }
    for(int i = 0; i<n;i++){
     for(int j = 0; j < i; j++){
        if(nums[j] < nums[i]){
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
     }
    }
    
    for(int i = 0; i < n; i++){
        if(dp[i] > mx){mx = dp[i];}
    }
    
        
    
    return mx;
    }
    
}
