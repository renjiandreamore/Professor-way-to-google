/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 16-10-01 20:42
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if(A == null || A.length == 0 || k > A.length){
            return A;
        }
        
        
        int[] res = new int[k];
        
        int index = findFirstIndex(A, target);
        
        int start = index - 1;
        int end = index;
        
        for(int i = 0; i < k; i++){
            if(start < 0){
                res[i] = A[end];
                end++;
            }else if(end >= A.length){
                res[i] = A[start];
                start--;
            }else{
                if(target - A[start] <= A[end] - target){
                    res[i] = A[start];
                    start --;
                }else{
                    res[i] = A[end];
                    end ++;
                }
            }
        }
        return res;
        
        
    }
    
    int findFirstIndex(int[] A, int target){
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {   //判断条件要加上
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }
}