```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/burst-balloons
@Language: Markdown
@Datetime: 16-04-08 02:46
```

例子 3，1，5，8

dp

左右各补一个1
1，3，1，5，8，1
计算3-8之间dp最大值时：
比如k指向3，可认为：
								先计算3左边dp最大值，（没有，所以为0），3右边（1，5，8）dp最大值（dp[3][8]），再计算3的价值，1*3*1（因为158已经计算过，所以当做 孤立3的时候的价值，即1*3*1）