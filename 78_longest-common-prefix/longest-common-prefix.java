/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 16-11-02 15:17
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0){
            return "";
        }
        // for(int i = 0; i < strs.length;i++){
        //     if(strs[i] == null || strs[i].length()==0){
        //         return "";
        //     }
        // }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() == 0){
                    return "";
                }
                if(strs[j].charAt(i) != ch){
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}