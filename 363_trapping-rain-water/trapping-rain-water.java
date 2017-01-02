/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 16-11-14 00:15
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length <=2){
            return 0;
        }
        
        int ans = 0;
        int left = 0;
        int right = heights.length - 1;
        
        int leftHigh = heights[left];
        int rightHigh = heights[right];
        
        while(left < right){
            if(leftHigh <= rightHigh){
                left++;
                if(leftHigh > heights[left]){
                    ans += leftHigh - heights[left];
                }else{
                    leftHigh = heights[left];
                }
            }else{
                right--;
                if(rightHigh > heights[right]){
                    ans += rightHigh - heights[right];
                }else{
                    rightHigh = heights[right];
                }
            }
        }
        
        return ans;
    }
}