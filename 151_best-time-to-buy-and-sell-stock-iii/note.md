```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Markdown
@Datetime: 16-10-15 14:10
```

left表示从左向右，正数前N天可获得的最大利润
right表示从右向左，倒数N天买，可获得的最大利润(left从左边买完，还剩余可买的天数里可买的最大利润）

[4,4,6,1,1,4,2,5] 返回6

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
	 
	 
	 
	 
	 
	 
	 
	 
    public int maxProfit(int[] prices) {
        // write your code here
        //动态规划
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int profit = 0;
        
        if(prices.length ==0||prices ==null){
            return 0;
        }
        
        //goes from left
        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i< left.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            //或者写成 min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        //goes from right
        right[right.length - 1] = 0;
        int max = prices[prices.length - 1];
        for(int i = right.length - 2; i>= 0; i--){
            if(prices[i] > max){
                max = prices[i];
            }
            //或者写成 max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }
        
        //算利润
        for(int i =0; i< prices.length; i++){
            if(left[i] + right[i] > profit){
                profit = left[i] + right[i];
            }
            //或者写成 profit = Math.max(left[i] + right[i], profit);
        }
        
        return profit;
    }
};