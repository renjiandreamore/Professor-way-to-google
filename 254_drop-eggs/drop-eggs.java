/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 16-11-13 01:56
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        if(n <= 0){
            return -1;
        }
        long res = 0;
        //int dif = Integer.MAX_VALUE;
        
        for(int i = 1; ; i++){
            res += (long)i;
            if(res >= (long)n){
                return i;
            }
        }
        
        //return res;
    }
}