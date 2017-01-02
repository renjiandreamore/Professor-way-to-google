/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-04-02 20:24
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        //找两个指针i，j 
        //i从左找大写字母，j从右找小写字母，交换
        
        int i = 0;
        int j = chars.length-1;
        
        
        while(i <= j){
            while(i<=j && Character.isLowerCase(chars[i])){
                i++;
            }
            while(i<=j && Character.isUpperCase(chars[j])){
                j--;
            }
            if(i <= j){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return;
    }
}
