/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/paint-house
@Language: Java
@Datetime: 16-11-28 15:08
*/

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        for(int i = 1; i < costs.length; i++){
            costs[i][0] = Math.min(costs[i-1][1], costs[i-1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i-1][0], costs[i-1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i-1][0], costs[i-1][1]) + costs[i][2];
        }
        
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]),  costs[costs.length - 1][2]);
    }
}