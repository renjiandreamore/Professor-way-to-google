/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/spiral-matrix-ii
@Language: Java
@Datetime: 16-11-23 21:42
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        if(n <= 0){
            return new int[0][0];
        }
        
        int[][] m = new int[n][n];
        
        int count = 0;
        int sum = 0;
        
        while(2*count < n){
            // if(sum == n*n){
            //     break;
            // }
            
            for(int i = count; i < n - count; i++){
                m[count][i] = sum + 1;
                sum++;
            }
            
            
            for(int j = count + 1; j < n - count; j++){
                m[j][n-1-count] = sum + 1;
                sum++;
            }
            
            
            
            for(int i = n - 2 - count; i >= count; i--){
                m[n-1-count][i] = sum + 1;
                sum++;
            }
            
            for(int j = n - 2 - count; j >= count + 1; j--){
                m[j][count] = sum + 1;
                sum++;
            }
            if(sum == n*n){
                break;
            }
            
            count++;
        }
        
        return m;
    }
}