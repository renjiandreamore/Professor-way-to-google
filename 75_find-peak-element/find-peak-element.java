/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 16-04-04 22:14
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1;
        int end = A.length - 2; 
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]){
                end = mid;
            }else if(A[mid] < A[mid + 1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        //return end;
        if(A[start] < A[end]){
            return end;
        }else{
            return start;
        }
        
    }
}
