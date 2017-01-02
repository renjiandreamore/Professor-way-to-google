/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/set-matrix-zeroes
@Language: Java
@Datetime: 16-11-02 23:35
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean Zero_row = false;
        boolean Zero_col = false;
        
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                Zero_row = true;
                break;
            }
        }
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                Zero_col = true;
                break;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(Zero_row){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(Zero_col){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}