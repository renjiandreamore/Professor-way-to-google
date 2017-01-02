/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 16-12-06 05:57
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0) return;
        
        int start = 0;
        int end = colors.length - 1;
        int count = 0; //1ĺ°k
        
        while(count < k){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = start; i <= end; i++){
                max = Math.max(max, colors[i]);
                min = Math.min(min, colors[i]);
            }
            
            int left = start;
            int right = end;
            int cursor = left;
            while(cursor <= right){
                if(colors[cursor] > min && colors[cursor] < max) {
                    cursor ++;
                }else if(colors[cursor] == min){
                    swap(colors, cursor, left);
                    left++;
                    cursor++;
                }else{
                    swap(colors, cursor, right);
                    right--;
                }
            }
            count += 2;
            start = left;
            end = right;
        }
    }
    
    public void swap(int[] colors, int left, int right){
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}