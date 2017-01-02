/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-10-15 14:10
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int bnf = 0;
        
        //before ith day(inclusive), the max profit
        left[0] = 0;
        int min1 = prices[0];
        for(int i = 1; i < n; i++){
            min1 = Math.min(min1, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min1);
        }
        
        //after ith day(exclusive)错，其实可以inclusive, the max profit
        right[n-1] = 0;
        int max = prices[n-1];
        for(int i = n - 2; i>=0; i--){
            max = Math.max(max,prices[i]);
            right[i] = Math.max(right[i+1], max - prices[i]); // max(right[i+1]!!) 不是right[i]!!      
        }
        
        //add them together
        for(int i = 0; i < n; i++){
            bnf = Math.max(bnf, left[i] + right[i]);
        }
        
        return bnf;
    }
};