/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/submatrix-sum
@Language: Java
@Datetime: 16-11-19 21:36
*/

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0][0];
        }
        int[][] res = new int[2][2];
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] sum = new int[m+1][n+1];
        
        //preprocess     sum[i][j] = the rectangle sum from (0,0) -> (i, j);
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int k = i + 1; k <= m; k++){
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int j = 0; j <= n; j++) {
                    int diff = sum[k][j] - sum[i][j];
                    if(map.containsKey(diff)){
                        int l = map.get(diff);
                        res[0][0] = i;
                        res[0][1] = l;
                        res[1][0] = k - 1;
                        res[1][1] = j - 1;
                    }else{
                        map.put(diff, j);
                    }
                }
            }
        }
        
        return res;
    }
}