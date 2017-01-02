/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-words
@Language: Java
@Datetime: 16-10-26 17:01
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> res = new ArrayList<>();
        if(dictionary == null || dictionary.length == 0){
            return res;
        }
        int len = 0;
        for(int i = 0; i < dictionary.length; i++) {
            if(len <= dictionary[i].length() ){
                len = dictionary[i].length();

            }
        }
        for(String s: dictionary){
            if(s.length() == len ){
                res.add(s);
            }
        }
        return res;
    }
};