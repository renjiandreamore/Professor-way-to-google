```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Markdown
@Datetime: 16-10-25 01:06
```

//把第i-1个数调整到0-100之间的某个数j，并且把第i个数调整到0-100之间的某个数k，满足 k - j <= target的情况

f[i][j] 看做以第i个数结尾的前i个数， 最后一个数（第i个数）调整到j，并且满足条件(可以达到两两之间差<=target)的最小花费。

j是前i-1个数调整到的那个值，不管他，再遍历一遍k 0 - 100， k表示前i个数调整到的那个值，不管他。只要满足k-j <= target就行了。其他自然是max_value;