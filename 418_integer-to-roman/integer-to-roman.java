/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/integer-to-roman
@Language: Java
@Datetime: 16-11-24 17:23
*/

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        if(n <= 0){
            return "";
        }
        
        int[] intgr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        //num = 48
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int times = n / intgr[index];
            n = n % intgr[index];
            while(times > 0){
                sb.append(roman[index]);
                times--;
            }
            index++;
        }
        
        return sb.toString();
    }
}