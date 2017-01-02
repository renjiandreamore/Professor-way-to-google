/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/plus-one
@Language: Java
@Datetime: 16-11-16 23:01
*/

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if(digits == null || digits.length == 0) return new int[0];
        int n = digits.length;
        
        int add = 1;
        for(int i = digits.length - 1; i >= 0; i-- ){
            if((digits[i] + add) == 10){
                digits[i] = 0;
                add = 1;
            }else{
                digits[i] += add;
                add = 0;
            }
        }
        
        if(add == 1){
            int[] res = new int[n + 1];
            res[0] = 1;
            for(int i = 1; i < n + 1; i++){
                res[i] = 0;
            }
            return res;
        }
        
        return digits;
    }
}