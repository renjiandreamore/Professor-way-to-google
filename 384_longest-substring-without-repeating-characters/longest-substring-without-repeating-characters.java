/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-substring-without-repeating-characters
@Language: Java
@Datetime: 16-10-23 16:37
*/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] ascii = new int[256];
        int left = 0;
        int right = 0;
        int ans = 0;
        
        for(left = 0; left < s.length(); left++ ){
            while( right < s.length() && ascii[s.charAt(right)] == 0){
                ascii[s.charAt(right)] = 1;
                ans = Math.max(ans,right - left + 1);
                right++;
            }
            if(right >= s.length()){
                break;
            }
            ascii[s.charAt(left)] = 0;
        }
        return ans;
    }
}