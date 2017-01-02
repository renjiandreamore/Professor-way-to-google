/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 16-04-07 00:13
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if(A.length == 0 || A == null){
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        
        while(start + 1 < end){
            mid = (start + end)/2;
            if(A[start] < A[mid]){  // first situation
                if(A[start] <= target && target <= A[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            }
            else{           // second situation
                if(A[mid] <= target && target <= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(A[start] == target){
            return start;
        }else if(A[end] == target){
            return end;
        }
        return -1;
    }    
}
