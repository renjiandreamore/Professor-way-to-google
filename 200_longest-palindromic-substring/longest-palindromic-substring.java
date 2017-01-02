/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Java
@Datetime: 16-11-09 17:32
*/

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
     
     /**
      * abcba这样的奇数个长度可由c左右推，看是否相等判断。但是abba这样偶数长度，我们没法找到b和b之间的那个数，所以思想是无论奇偶我们都把长度扩大一倍，扩大后的偶数各位用#表示，扩大后的奇数各位用原字符串string的从0-s.len-1的各个位置字符表示.
      * 
        abba --> #a#b#b#a ,后面再补一个#即可, 有效性是从第三个#开始左右移动判断。
        abcba --> #a#b#c#b#a, 后面再补一个#即可，有效性是从c开始左右移动判断
      */
    public String longestPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() ==0){
            return "";
        }
        
        int sum = 0;
        //int count = 1;
        int len = s.length();
        String res = "";
        
        for(int i = 1; i < 2*len; i++){
            int count = 1;
            while(i-count >= 0 && i+count<= 2*len && get(s,i-count) == get(s, i+ count)){
                count++;
            }
            
            count--;
            if(count > sum){
                res = s.substring( (i-count)/2, (i+count)/2);
                sum = count;
            }
        }
        return res;
        
    }
    
    public char get(String s, int i){
        if(i %2 == 0){
            return '*';
        }else{
            return s.charAt(i/2);
        }
    }
}