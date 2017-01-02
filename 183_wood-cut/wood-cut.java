/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-09-07 19:46
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int sum = 0;
        for(int i =0; i < L.length;i++){
            sum = Math.max(sum, L[i]);
        }
        
        int start = 1;
        int end = sum;
        
        while(start + 1 < end){
            int mid = start + (end-start)/2; // 为了当int为最大值时候 start + end不会溢出变为 integer.min
            if(count(L, mid) >= k){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(count(L, end) >= k){
            return end;
        }
        if(count(L,start) >= k){
            return start;
        }
        return 0;
        
        
    }
    private int count(int[]L, int length){
        int sum = 0;
        for(int i = 0;i<L.length;i++){
            sum += L[i]/length;
        }
        return sum;
    }
}