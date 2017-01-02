/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Java
@Datetime: 16-11-23 22:02
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = heights.length - 1;
        
        int area = 0;
        
        while(start < end){
            area = Math.max(area, getArea(start, end, heights));
            if(heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }
        
        return area;
        
    }
    
    public int getArea(int i, int j, int[] A){
        return (j - i) * (Math.min(A[i], A[j]));
    }
}