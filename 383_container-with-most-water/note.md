```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Markdown
@Datetime: 16-11-23 22:02
```

左边某点i为起点，**往右**能达到的最长的距离，且满足那个点比他高，就是i往左的最大面积。

同理

右边某点j为起点，**往左**能达到的最长的距离，且满足那个点比他高，就是j往右的最大面积。

所以每次相对高度较小的那一端，往相对方向移动一格，必属于上述两条件之一。记录最大值就好了。