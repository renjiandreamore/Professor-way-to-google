/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 16-08-31 22:46
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        
        int n = s1.length();
        int m = s2.length();
        
        if(n + m != s3.length()){return false;}
        
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        
        for(int i = 1; i < n+1; i++){
            dp[i][0] = (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]);
        }
        for(int i = 1; i < m+1; i++){
            dp[0][i] = (s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]);
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) ||
                    dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        
        return dp[n][m];
    }
}