/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-02-29 17:56
*/

import java.util.Arrays;

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if(A.length == 0 || A == null){
            return new int[]{-1,-1};
        }
        
        int start, end, mid;
        int[] result = new int[2];
        
        start = 0;
        end = A.length - 1;
        
        while(start + 1< end){
            mid = (start + end)/2;
            if(A[mid] == target){
                end = mid;
            }else if( A[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }
        if( A[start] == target ){
            result[0] = start;
        }else if ( A[end] == target){
            result[0] = end;
        }else {
            result[0] = result[1] = -1;
            return result;
        }
        
       start = 0;
       end = A.length - 1;
        
        while(start + 1< end){
            mid = (end + start)/2;
            if(A[mid] == target){
                start = mid;
            }else if(A[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }
        if(A[end] == target){   //找最后一个要先判断if A[end] == target
            result[1] = end;     
        }else if(A[start] == target){
            result[1] = start;
        }else {
            result[0] = result[1] = -1;
            return result;
        }
        return result;
        
       
       
       
    }
}
