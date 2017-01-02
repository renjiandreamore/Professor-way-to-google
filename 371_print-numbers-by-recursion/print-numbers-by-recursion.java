/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/print-numbers-by-recursion
@Language: Java
@Datetime: 16-11-12 21:31
*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper(n, 0, res);
        return res;
    }
    
    void helper(int n, int ans, List<Integer> res){
        if(n == 0 ){
            if(ans >0){
                res.add(ans);
            }
            return;
        }
        
        for(int i = 0; i <= 9; i++){
            helper(n-1, ans*10 + i, res);
        }
    }
}