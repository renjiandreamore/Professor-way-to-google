/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 16-02-28 21:21
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        int len = A.length;
        if(len == 0 || A == null || A[0] > target || A[len -1] < target){
            return -1;
        }
        if(A[len - 1] == target){
            return len - 1;
        }
        
        int start = 0;
        int end = len -1;
        
        
        while( start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                start = mid;
            }else if (A[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] == target){
            return start;
        }else if ( A[end] == target){
            return end;
        }else {
            return -1;
        }
    }
}