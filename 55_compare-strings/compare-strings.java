/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-10-21 04:16
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        
        if(A == null || B.length() > A.length()) return false;
        if(B == null) return true;
        
        
        // for(int i = 0; i < B.length() ; i++ ){
        //     boolean found = false;
        //     for(int j = 0; j < A.length(); j++){
        //         if( A.charAt(j) == B.charAt(i)){
        //             found = true;
        //             A.replace(A.charAt(j), '1');
        //             break;
        //         }
        //     }
        //     if(found == false) {
        //         return false;
        //     }
        // }
        // return true;
        
        //以上我觉得可以过 ！！
        
        int[] found = new int[26];
        
        for(int i = 0; i < A.length(); i++){
            int letter = A.charAt(i) - 'A';
            found[letter] ++ ;
        }
        
        for(int i = 0; i < B.length(); i++){
            int letter = B.charAt(i) - 'A';
            found[letter] -- ;
            if(found[letter] < 0){
                return false;
            }
        }
        return true;
        
    }
}