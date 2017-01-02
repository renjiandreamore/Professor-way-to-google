```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Markdown
@Datetime: 16-10-12 23:11
```

public class Solution {
/**
* @param prices: Given an integer array
* @return: Maximum profit
*/
public int maxProfit(int[] prices) {
// write your code here
if(prices == null || prices.length == 0){
return 0;
}
int min = Integer.MAX_VALUE, profit = 0;
for(int i =0; i&lt;prices.length; i++){
if(prices[i] &lt; min){
min = prices[i];
}
if(prices[i] - min &gt; profit){
profit = prices[i] - min;
}
}
return profit;
}
}

前i个位置的最大profit，=    当前位置的利益profit[i] 减去➖ 前i个位置里的最小值min， 与第i个位置之前已经算出来的前i-1个利益的比值大的那个