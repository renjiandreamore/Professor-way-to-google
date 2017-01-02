```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Markdown
@Datetime: 16-11-29 12:15
```

找到第一个下降的位置i，停止加入stack
	计算好最大面积后， 吧i左边比 height[i] 高的地方全都cut掉， 当做和i一样高的一个阶梯，只是宽度为所有加上i的宽度，把它当做一个阶梯。
	然后再向右继续。
	
最右边多增加一个高度为0的阶梯。