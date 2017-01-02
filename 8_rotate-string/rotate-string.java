/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/rotate-string
@Language: Java
@Datetime: 16-10-21 03:24
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public char[] rotateString(char[] A, int offset) {
        // write your code here
        // String s = "";
        // offset = offset % str.length;
        // for(int i = str.length - offset; i < str.length; i++){
        //     s += String.valueOf(str[i]);
        // }
        
        // for(int i = 0; i < str.length - offset; i++){
        //     s += String.valueOf(str[i]);
        // }
        
        // return s.toCharArray();
        // //str = s.toCharArray();
    //}
        
        if (A == null || A.length == 0) {
            return A;
        }
        
        offset = offset % A.length;
        reverse(A, 0, A.length - offset - 1);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        return A;
    }
    
    private void reverse(char[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    
}