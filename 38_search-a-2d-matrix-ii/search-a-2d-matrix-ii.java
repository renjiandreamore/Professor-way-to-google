/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 16-02-29 06:26
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        int count = 0;
        
        
        while(x >= 0 && y < col){
            if(matrix[x][y] == target){
                count ++;
                x--;
                y++;
            }else if ( matrix[x][y] < target){
                y++;
            }else {
                x--;
            }
        }
        return count;
    }
}
