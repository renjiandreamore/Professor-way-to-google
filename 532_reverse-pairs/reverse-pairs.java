/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Java
@Datetime: 16-12-07 19:12
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if(A == null || A.length == 0) return 0;
        return mergeSort(A, 0, A.length - 1);
    }
    
    public int mergeSort(int[] A, int start, int end){
        if(start >= end) return 0;
        
        int mid = (start + end)/2;
        int sum = 0;
        
        sum+= mergeSort(A, start, mid);
        sum+= mergeSort(A, mid + 1, end);
        sum+= merge(A, start, mid, end);
        
        return sum;
    }
    
    public int merge(int[] A, int start, int mid, int end){
        int left = start;
        int right = mid + 1;
        
        int[] tmp = new int[A.length];
        int index = start;
        int sum = 0;
        
        while(left <= mid && right <= end){
            if(A[left] <= A[right]){
                tmp[index++] = A[left++];
            }else{
                tmp[index++] = A[right++];
                sum += (mid - left + 1);
            }
        }
        
        while(left<=mid){
            tmp[index++] = A[left++];
        }
        
        while(right<=end){
            tmp[index++] = A[right++];
        }
        
        for(int i = start; i <= end; i++){
            A[i] = tmp[i];
        }
        
        return sum;
    }
}