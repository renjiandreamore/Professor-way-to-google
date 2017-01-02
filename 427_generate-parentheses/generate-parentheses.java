/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Java
@Datetime: 16-12-01 03:30
*/

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        if(n <= 0) return res;
        
        helper(res, "", n, n);
        
        return res;
    }
    
    public void helper(ArrayList<String> res, String pare, int left, int right){
        if(left == 0 && right == 0){
            res.add(pare);
            return;
        }
        
        if(left > 0){
            //pare += "(";
            helper(res, pare +"(", left - 1, right);
        }
        
        if(right > 0 && left < right){
            //pare += ")";
            helper(res, pare +")", left, right - 1);
        }
    }
}