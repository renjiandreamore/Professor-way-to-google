/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-10-01 18:41
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        // int x = Integer.MAX_VALUE;
        // int index = 0;
        // for(int i = 0; i < A.length; i++){
        //     int dif = Math.abs(target-A[i]);
        //     if(dif < x){
        //         x = dif;
        //         index = i;
        //     }
        // }
        // return index;
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1< end){
            int mid = start + ( end - start)/2;
            if(A[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(Math.abs(A[start] - target) < Math.abs(A[end] - target)){
            return start;
        }else{
            return end;
        }
    
    }
}