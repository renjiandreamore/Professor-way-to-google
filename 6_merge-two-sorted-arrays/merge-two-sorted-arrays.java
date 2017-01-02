/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-03-13 19:57
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        
        int[] test = new int[A.length + B.length];
        int i = A.length -1, j = B.length -1, index = A.length+B.length -1;
        
        while(i>=0 && j>= 0){
            if(A[i] > B[j]){
                test[index] = A[i];
                i--;
                index--;
            }else{
                test[index--] = B[j--];
            }
        }
        
        while(i>=0){
            test[index--] = A[i--];
        }
        while(j>=0){
            test[index--] = B[j--];
        }
        
        return test;
    }
}