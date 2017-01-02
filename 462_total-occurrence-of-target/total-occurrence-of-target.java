/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-09-30 22:38
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        // int count = 0;
        // for(int i = 0; i < A.length; i++){
        //     if(A[i] == target){
        //         count ++;
        //     }
        // }
        // return count;
        
        // int n = A.length;
        // if(n == 0 || A[n-1] < target || A[0] > target){
        //     return 0;
        // }
        
        // int start = 0;
        // int end = n - 1;
        // int First = 0;
        // int Last = n - 1;
        
        
        // while(start +1 < end){
        //     int mid = start + (end - start)/2;
        //     if(A[mid] >= target){
        //         end = mid;
        //     }else{
        //         start = mid;
        //     }
        // }
        // if(A[start] ==target ){
        //     First = start;
        // }else{
        //     First = end;
        // }
        
        // int start1 = 0;
        // int end1 = n -1;
        // while(start1 + 1 < end1){
        //     int mid = start1 + ( end1 - start1)/2;
        //     if(A[mid] <= target){
        //         start1 = mid;
        //     }else{
        //         end1 = mid;
        //     }
        // }
        // if(A[end1] == target){
        //     Last = end1; 
        // }else{
        //     Last = start1;
        // }
        
        // return Last - First + 1;
        
        int n = A.length;
        if (n == 0)
            return 0;
        if (A[n-1] < target || A[0] > target)
            return 0;
        
        int l = 0, r = n - 1;
        int start = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (A[mid] >= target) {
                start = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        if (A[start] != target)
            return 0;

        int end = n-1;
        l = 0; r = n-1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (A[mid] <= target) {
                end = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return end - start + 1;
        
    }
}