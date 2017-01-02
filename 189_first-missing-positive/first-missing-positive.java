/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 16-11-07 01:23
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here  
        if(A == null || A.length == 0){
            return 1;
        }
        
        for(int i = 0; i < A.length; i++){
            while(i+1 != A[i] && A[i] <= A.length && A[i] > 0){
                int tmp = A[A[i]-1];
                if(tmp == A[i]){
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] != i+1){
                return i +1;
            }
        }
        return A.length + 1;
    }
}