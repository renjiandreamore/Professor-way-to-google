/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning-ii
@Language: Java
@Datetime: 16-08-23 15:10
*/

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        
        for(int i = 0; i<n+1; i++){
            dp[i] = i - 1;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < i; j++){
                if(isPalindrome(s, j, i-1)){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
		
        
    }
    private boolean isPalindrome(String s, int start, int end){
		for(int i = start, j = end; i < j; i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
}














// if(s == null || s.length() == 0){
//             return 0;
//         }
//         int n = s.length();
//         int[] dp = new int[n+1];
        
//         for(int i = 0; i<= n; i++){
//             dp[i] = i - 1;
//         }
        
//         for(int i = 1; i <=n; i++){
//             for(int j = 0; j < i; j++){
//                 if(isPalindrome(s, j, i-1)){
//                     dp[i] = Math.min(dp[j] + 1, dp[i]);
//                 }
//             }
//         }
//         return dp[n];