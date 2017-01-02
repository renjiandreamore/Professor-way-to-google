/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 16-10-25 01:06
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] f = new int[n + 1][101];
        for (int i = 0; i <= n ; ++i){
            for (int j = 0; j <=100; ++j){
                f[i][j] = Integer.MAX_VALUE;
            }
        }
         
        for (int i = 0; i <= 100; ++i){
            f[0][i] = 0;
        }
        
        
        for (int i = 1; i <=n; ++i){
            for (int  j = 0; j <= 100;++j){
                if (f[i-1][j] != Integer.MAX_VALUE){
                	for (int k = 0; k <= 100; ++k){
                	    //把第i-1个数调整到0-100之间的某个数j，并且把第i个数调整到0-100之间的某个数k，满足 k - j <= target的情况
                	    //f[i][j] 看做以第i个数结尾的前i个数， 最后一个数（第i个数）调整到j，并且满足条件(可以达到两两之间差<=target)的最小花费。
                		if (Math.abs(j-k) <= target){
                			if (f[i][k] > f[i-1][j] + Math.abs(A.get(i-1)-k)){
                				f[i][k] = f[i-1][j] + Math.abs(A.get(i-1)-k); 
                			}
                		}
                	}
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; ++i){
            if (f[n][i] < ans){
                ans = f[n][i];
            }
        }
        return ans; //ans
    }
}