/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 16-11-14 05:47
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int m, n;
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return ans;
        
    }
    
    public void dfs(boolean[][] grid, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        
        if(grid[i][j]){
            grid[i][j] = false;
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            //grid[i][j] = true;
        }
    }
}