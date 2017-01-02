/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-03-13 19:51
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        
        int i = m-1, j =n-1, k = n + m -1;
        
        while(i>=0 && j>=0){
            if(A[i] < B[j]){
                A[k] = B[j];
                k--;
                j--;
            }else{
                A[k--] = A[i--];
            }
        }
        while(i >= 0){
            A[k--] = A[i--];
        
        }
        while(j >= 0){
            A[k] = B[j];
            k--;
            j--;
        }
    
    }
}