```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Markdown
@Datetime: 16-03-29 03:06
```

比如 [-3, 1, 2, -3, 4]
有和为0的条件其实是：把数组依次每个位数相加后，还能变回原来的值。所以先把0和位置-1 put进 哈希图.