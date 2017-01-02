/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 16-11-08 05:09
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A== null || A.length == 0){
            return 0;
        }
        int sum = 1;
        
        int len = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1]){
                len++;
            }else{
                len = 1;
            }
            sum= Math.max(sum, len);
        }
        
        len = 1;
        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > A[i+1]){
                len++;
            }else{
                len = 1;
            }
            sum = Math.max(sum , len);
        }
        
        return sum;
        
        
    }
}