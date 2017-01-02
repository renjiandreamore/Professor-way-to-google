/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-10-12 23:17
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <2){
            return 0;
        }
        
        int bnf = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i+1] - prices[i] > 0){
                bnf += prices[i+1] - prices[i];
            }
        }
        return bnf;
    }
};