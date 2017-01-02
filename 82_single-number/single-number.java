/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-10-23 01:32
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        // Arrays.sort(A);
        // if(A.length == 1){
        //     return A[0];
        // }
        // if(A.length == 3){
        //     if(A[0] == A[1]) return A[2];
        //     if(A[0] == A[2]) return A[1];
        //     if(A[1] == A[2]) return A[0];
        // }
        
        // for(int i = 0; i < A.length -2; i++){
        //     if(A[i] != A[i+1] && A[i+1] != A[i+2]){
        //         return A[i+1];
        //     }
        // }
        // return 0;
        
        if(A == null || A.length == 0){
            return 0;
        }
        
        int res = 0;
        for(int i = 0; i < A.length; i++){
            res = res ^ A[i];
        }
        
        return res;
    }
}