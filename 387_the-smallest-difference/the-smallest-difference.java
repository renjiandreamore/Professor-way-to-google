/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/the-smallest-difference
@Language: Java
@Datetime: 16-11-08 04:59
*/

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if(A==null && B== null || A.length == 0 && B.length ==0){
            return 0;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        int dif = Integer.MAX_VALUE;
        
        for(int i = 0, j = 0; i<A.length && j<B.length;){
            int d = Math.abs(A[i] - B[j]);
            dif = Math.min(dif, d);
            if(A[i] > B[j]){
                j++;
            }else{
                i++;
            }
        }
        
        return dif;
    }
}
