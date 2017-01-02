/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-integers-ii
@Language: Java
@Datetime: 16-12-23 02:35
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        //quick Sort
        if(A == null || A.length == 0) return;
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end){
        if(start >= end) return;
        
        int pivot = A[(start + end)/2];
        int i = start, j = end;
        while(i <= j){
            while(A[i] < pivot){
                i++;
            }
            while(A[j] > pivot){
                j--;
            }
            if(i <= j){
                swap(A, i, j);
                i++;
                j--;
            }
           
        }
        
        quickSort(A, start, j);
        quickSort(A, i, end);
    }
    
    public void swap(int[]A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}