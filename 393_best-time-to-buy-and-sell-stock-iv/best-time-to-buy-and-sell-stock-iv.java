/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Java
@Datetime: 16-10-15 21:41
*/

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2){
            return 0;
        }
        
        int n = prices.length;
        
        if(k >= n) return maxProfit2(k, prices);
        
        int[][] global = new int[n][k+1];
        int[][] local = new int[n][k+1];
        
        global[0][0] = local[0][0] = 0;
        
        // for(int i = 1; i <= k; i++){
        //     global[0][i] = local[0][i] = 0;
        // }
        
        for(int i = 1; i < n; i++){
            int dif = prices[i] - prices[i-1];
            //local[i][0] = 0;
            for(int j = 1; j <= k; j++){
                local[i][j] = Math.max(global[i-1][j-1], local[i-1][j] + dif);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        
        return global[n-1][k];
    }
    
    public int maxProfit2(int k, int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
};