/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 16-10-03 01:55
*/

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        //要考虑到有0的情况
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i<= s.length(); i++){
            if(s.charAt(i - 1) != '0'){
                dp[i] = dp[i-1];
            }
            
            int twoDigits = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
}