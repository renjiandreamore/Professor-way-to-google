/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-10-01 22:09
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        //write your code here
        // for(int i = 0; i < A.length; i++){
        //     if(A[i] == target){
        //         return true;
        //     }
        // }
        // return false;
        
        if(A == null || A.length == 0){
            return false;
        }
        
        int start = 0, end = A.length - 1;
        int mid;
        
        while(start + 1 < end){
            mid = (start + end)/2;
            if(A[start] < A[mid]){
                if(A[start] <= target && target <= A[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(A[start] == A[mid]){
                start++;
            }
            else{
                if(A[mid] <= target && target <= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(A[start] == target){
            return true;
        }
        if(A[end] == target){
            return true;
        }
        return false;
    }
}
