/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/paint-house-ii
@Language: Java
@Datetime: 16-11-28 15:57
*/

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        // if(costs == null || costs.length == 0) return 0;
        
        // int num = costs.length;
        // int k = costs[0].length;
        
        // int[][] dp = new int[num+1][k];
        // for(int i = 0; i < num; i++){
        //     for(int j = 0; j < k; j++){
        //         dp[i+1][j] = Integer.MAX_VALUE;
        //     }
        // }
        
        // for(int i = 0; i < num; i++){
        //     for(int j = 0; j < k; j++){
        //         for(int s = 0; s < k; s++){
        //             if(s != j){
        //                 dp[i+1][j] = Math.min(costs[i][j] + dp[i][s], dp[i+1][j]);
        //             }
        //         }
        //     }
        // }
        
        // int ans = Integer.MAX_VALUE;
        
        // for(int i = 0; i < k; i++){
        //     ans = Math.min(ans, dp[num][i]);
        // }
        
        // return ans;
        if(costs != null && costs.length == 0) return 0;
        int prevMin = 0, prevSec = 0, prevIdx = -1;
        for(int i = 0; i < costs.length; i++){
            int currMin = Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIdx = -1;
            for(int j = 0; j < costs[0].length; j++){
                costs[i][j] = costs[i][j] + (prevIdx == j ? prevSec : prevMin);
                // 找出最小和次小的，最小的要记录下标，方便下一轮判断
                if(costs[i][j] < currMin){
                    currSec = currMin;
                    currMin = costs[i][j];
                    currIdx = j;
                } else if (costs[i][j] < currSec){
                    currSec = costs[i][j];
                }
            }
            prevMin = currMin;
            prevSec = currSec;
            prevIdx = currIdx;
        }
        return prevMin;
    }
}