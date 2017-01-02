/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 16-10-12 23:11
*/

public class Solution {
 /**
 * @param prices: Given an integer array
 * @return: Maximum profit
 */
 public int maxProfit(int[] prices) {
 // write your code here
 // 2,3,1,4,6,0,4
    if(prices == null || prices.length < 2){
        return 0;
    }
    
    int crtMin = prices[0]; // 2
    int bnf = 0;
    for(int i = 1; i < prices.length; i++){
        crtMin = Math.min(crtMin, prices[i]);
        bnf = Math.max(bnf, prices[i] - crtMin);
    }
    
    return bnf;
    
    // 前i个位置的最大profit，=    当前位置的利益profit[i] 减去➖ 前i个位置里的最小值min， 与第i个位置之前已经算出来的前i-1个利益的比值大的那个
    
 }
}