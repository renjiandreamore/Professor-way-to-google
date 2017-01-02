```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Markdown
@Datetime: 16-10-12 23:17
```

记录所有上升股票的和，就不用找最小值了，直接记录差值>0的情况，然后加起来就好。

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int profit = 0;
        for(int i=0; i<prices.length - 1; i++){
            int dif = prices[i+1] - prices[i];
            if(dif > 0){
                profit += dif;
            }
        }
        return profit;
    }
};