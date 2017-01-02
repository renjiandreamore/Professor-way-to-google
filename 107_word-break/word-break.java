/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-08-23 02:18
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
     
    private int getMaxLength(Set<String> dict){
        int maxLength = 0;
        for(String words : dict){
            if(words.length() >= maxLength){
                maxLength = words.length();
            }
        }
        return maxLength;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if(s == null || s.length()==0 || s.length()==1 && dict.contains(s)){
            return true;
        }
        int n = s.length();
        
        int maxLength = getMaxLength(dict);
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            dp[i] = false;
            for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength ++ ){
                if(!dp[i-lastWordLength]){
                    continue;
                }
                String word = s.substring(i-lastWordLength, i);
                if(dict.contains(word)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}