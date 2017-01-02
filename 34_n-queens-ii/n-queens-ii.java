/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-09-27 20:39
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int sum;
    public int totalNQueens(int n) {
        //write your code here
        sum = 0;
        if(n<=0){
            return sum;
        }
        
        int[] oneLayout = new int[n];
        helper(oneLayout, 0);
        return sum;
    }
    
    void helper(int[] oneLayout, int row){
        int n = oneLayout.length;
        if(row == n){
            sum++;
            return;
        }
        
        for(int i = 0; i < n; i ++){
            if(isValidPosition(oneLayout, row, i)){
                oneLayout[row] = i;
                helper(oneLayout,row+1);
                //oneLayout[row] = 0;
            }
        }
    }
    
    // ArrayList<String> translateToString(int[] oneLayout){
    //     ArrayList<String> res = new ArrayList<String>();
    //     for(int i = 0 ; i < oneLayout.length; i ++){
    //         StringBuilder sb = new StringBuilder();
    //         for(int j = 0; j < oneLayout.length; j++){
    //             if(oneLayout[i] == j){
    //                 sb.append("Q");
    //             }else{
    //                 sb.append(".");
    //             }
    //         }
    //         res.add(sb.toString());
    //     }
    //     return res;
    // }
    
    boolean isValidPosition(int[] oneLayout, int row, int col){
        for(int i = 0; i < row; i++){
            if(col == oneLayout[i]){
                return false;
            }
            if(Math.abs(col - oneLayout[i]) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }
};

