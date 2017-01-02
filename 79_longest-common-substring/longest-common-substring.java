/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 16-08-23 23:44
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int n = A.length();
        int m = B.length();
        
        int maxLength = 0;
        
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                int len = 0;
                while(i + len <n && j + len < m && A.charAt(i+len) == B.charAt(j+len)){
                    len ++;
                    if(len >= maxLength){maxLength = len;}
                }
            }
        }
        return maxLength;
    }
}