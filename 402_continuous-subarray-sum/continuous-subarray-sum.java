/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum
@Language: Java
@Datetime: 16-11-15 03:21
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        
        res.add(0);
        res.add(0);
        
        int start = 0, end = A.length - 1;
        int sum = 0;
        int ans = Integer.MIN_VALUE; //-0x7fffffff
        
        for(int i = 0; i < A.length; i++) {
            if(sum < 0){
                sum = A[i];
                start = end = i;
            }else{
                sum += A[i];
                end = i;
            }
            if(sum > ans){
                ans = sum;
                res.set(0,start);
                res.set(1,end);
            }
        }
        
        return res;
    }
}