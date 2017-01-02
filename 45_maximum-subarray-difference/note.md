```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Markdown
@Datetime: 16-03-28 23:00
```

最大绝对值可能为:
从左数最大的数-从右数最小的数 || 从右数最大的数-从左数最小的数

所以一共计算4个值

最后一部分也可亦表示为：
int dif = Integer.MIN_VALUE;
        for(int i =0; i< nums.length - 1; i++){
            dif = Math.max(dif, Math.abs(leftmax[i] - rightmin[i+1]));
            dif = Math.max(dif, Math.abs(leftmin[i] - rightmax[i+1]));
        }
        return dif;
