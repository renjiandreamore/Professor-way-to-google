```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Markdown
@Datetime: 16-04-17 18:59
```

递归+记忆化搜索：


public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    int n;
    int[][] triangle;
    int[][] hash;
    
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        n = triangle.length;
        this.triangle = triangle;
        hash = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return dc(0,0);
    }
    int dc(int x, int y){
        if(x >= triangle.length){
            return 0;
        }
        if(hash[x][y] != Integer.MAX_VALUE){
            return hash[x][y];
        }
        
        hash[x][y] = triangle[x][y] + Math.min(dc(x+1, y), dc(x+1, y+1));
        return hash[x][y];
    }
}


================
自底向上： f[i][j]表示从ij走到最底层的最短距离。于是只用返回f[0][0]就可以
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        //底层初始化:
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        
        return dp[0][0];
        
    }
}


====================
自顶向下：f[i][j] 表示从 0,0点走到i,j点需要的最短距离。 (一个是从ij走到底层，一个是从0,0走到i,j）
所以走到最后一层后要for一下找出最后一层里最短的那个.

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        //top - down
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        
        //初始化
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        //dp
        for(int i = 0; i < n; i++){
            for(int j = 1; j < i; j++ ){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        //找最后一行最小的那个.
        int best = dp[n-1][0];
        for(int i = 1; i < n; i++){
            best = Math.min(best, dp[n-1][i]);
        }
        return best;
        
    }
}




