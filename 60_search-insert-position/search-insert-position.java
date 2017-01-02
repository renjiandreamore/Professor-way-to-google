/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 16-02-29 06:57
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        for(int i =0; i < A.length; i++){
            if(A[0] >= target){
                return 0;
            }
            if(A[A.length - 1] < target){
                return A.length;
            }
            if(A[i] == target){
                return i;
            }else if(A[i] > target){
                return i;
            }else{
                continue;
            }
        }
        return 0;
    }
}
