/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/spiral-matrix
@Language: Java
@Datetime: 16-11-22 23:57
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int count = 0;
        
        while(2*count < m && 2*count < n) {
            for(int i = count; i < n - count; i++){
                res.add(matrix[count][i]);
            }
            
            for(int j = count + 1; j < m - count; j++){
                res.add(matrix[j][n-count-1]);
            }
            
            if(m-2*count == 1 || n-2*count == 1){
                break;
            }
            
            for(int i = n-count-2; i >= count; i--){
                res.add(matrix[m-count-1][i]);
            }
            
            for(int j = m - count - 2; j >= count + 1; j--){
                res.add(matrix[j][count]);
            }
            
            count++;
        }
        
        return res;
    }
}