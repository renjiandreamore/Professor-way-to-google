/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-10-26 00:35
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null || t == null || s.length() != t.length() ) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        
        for(int i = 0; i < t.length(); i++){
            if(!map.containsKey(t.charAt(i))) return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            if(map.get(t.charAt(i)) < 0) return false;
        }
        
        // for(int i : map.values() ){
        //     if(i != 0){
        //         return false;
        //     }
        // }
        
        return true;
    }
};