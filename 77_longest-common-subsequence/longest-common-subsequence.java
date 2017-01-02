/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 16-12-16 00:47
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int n = A.length();
        int m = B.length();
        
        int[][] f = new int[n+1][m+1];
        
        for(int i = 0; i < n+1; i++){
            f[i][0] = 0;
        }
        for(int j = 0; j < m+1; j++){
            f[0][j] = 0;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m + 1; j++){
                if(A.charAt(i-1) != B.charAt(j-1)){
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                }
                else if(A.charAt(i-1) == B.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + 1;
                }
            }
        }
        return f[n][m];
    }
}
