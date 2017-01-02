/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/count-1-in-binary
@Language: Java
@Datetime: 16-11-08 04:40
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int rs = 0;
        while(num != 0){
            rs += (num & 1);
            num = num >>> 1;
        }
        return rs;
    }
};