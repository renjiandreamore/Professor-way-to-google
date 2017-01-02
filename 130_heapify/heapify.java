/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 16-09-14 18:03
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        //Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            pushup(A,i);
        }
    }
    
    public void pushup(int[] A, int k){
       
        while(k != 0){
            int dad = (k-1)/2;
            if(A[k] > A[dad]){
                break;
            }
            int temp = A[k];
                A[k] = A[dad];
                A[dad] = temp;
                
                k = dad;
        }
    }
}