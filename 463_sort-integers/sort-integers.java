/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-integers
@Language: Java
@Datetime: 16-12-23 14:38
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        //merge Sort
        if(A == null || A.length == 0) return;
        int[] tmp = new int[A.length];
        
        mergeSort(A, 0, A.length - 1, tmp);
    }
    
    public void mergeSort(int[] A, int start, int end, int[] tmp){
        if(start >= end) return;
        
        int mid = (start + end)/2;
        mergeSort(A, start, mid, tmp);
        mergeSort(A, mid + 1, end, tmp);
        
        merge(A, start, mid, end, tmp);
    }
    
    public void merge(int[] A, int start, int mid, int end, int[] tmp){
        //if(start >= end) return;
        
        int i = start, j = mid + 1;
        int index = start;
        
        while(i <= mid && j <= end){
            if(A[i] < A[j]){
                tmp[index++] = A[i++];
            }else{
                tmp[index++] = A[j++];
            }
        }
        
        while(i <= mid){
            tmp[index++] = A[i++];
        }
        while(j <= end){
            tmp[index++] = A[j++];
        }
        
        for(int x = start; x <= end; x++){
            A[x] = tmp[x];
        }
    }
}