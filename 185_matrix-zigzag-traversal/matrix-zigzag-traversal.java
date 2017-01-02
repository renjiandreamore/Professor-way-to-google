/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/matrix-zigzag-traversal
@Language: Java
@Datetime: 16-11-08 02:32
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int x, dx, y, dy, count, m,n;
        x = y = 0;
        dx = -1;
        dy = 1;
        count = 1;
        m = matrix.length;
        n = matrix[0].length;
        
        int[] rs = new int[m*n];
        rs[0] = matrix[0][0];
        
        while(count < m*n){
            if(x + dx >=0 && y + dy >=0 && x + dx < m && y + dy < n){
                x += dx;
                y += dy;
            }else{
                if(dx == -1 && dy == 1){
                    if(y+1<n){
                        y++;
                    }else{
                        x++;
                    }
                    dx = 1; 
                    dy = -1;
                }else{
                    if(x+1 < m){
                        x++;
                    }else{
                        y++;
                    }
                    dx = -1;
                    dy = 1;
                }
            }
            rs[count] = matrix[x][y];
            count++;
        }
        
        return rs;
    }
}