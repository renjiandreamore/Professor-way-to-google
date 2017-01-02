/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 16-09-26 20:20
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null){
            return res;
        }
        List<String> path = new ArrayList<String>();
        helper(res, path, s, 0);
        return res;
        
    }
    
    void helper(List<List<String>> res, List<String> path, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(path));
            return;
        }
        
        
        for(int i = pos + 1; i <= s.length(); i++){
            if(!isPalindrome(s.substring(pos, i))){
                continue;
            }
            path.add(s.substring(pos, i));
            helper(res, path, s, i);
            path.remove(path.size()-1);
        }
    }
    
    boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start )!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}