/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-11-29 12:15
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        // int len = height.length;
        // int max = 0;
        // for(int i = 0; i < len; i++){
        //     int minHeight = height[i];
        //     for(int j =i; j >=0; j--){
        //         minHeight = Math.min(minHeight, height[j]);
        //         int square = minHeight * (i - j + 1);
        //         if(square > max){
        //             max = square;
        //         }
        //     }
        // }
        // return max;   
        // O(n*n) 复杂度，太慢
        
        /*
        用递增栈的解法：
        */
        
        if(height == null || height.length == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        int max = 0;
        
        for(int i = 0; i <= height.length; i++){
            int hait = (i == height.length ? 0 : height[i]);
            while(!st.isEmpty() && hait <= height[st.peek()]){
                int h = height[st.pop()];
                int w = (st.isEmpty()? i : i - st.peek() -1);
                int s = h * w;
                max = Math.max(s, max);
            }
            st.push(i);
        }
        
        return max;
        
    }
}
