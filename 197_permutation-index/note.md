```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Markdown
@Datetime: 16-11-11 13:12
```

以4,1,2为例，4为第3大数,1为剩余序列第1大数，2为剩余序列第1大数，

故表达式为：(3-1)*2! + (1-1)*1! + (1-1)*0! + 1 = 5

以2,4,1为例，2为第2大数，4为剩余序列第2大数，1为剩余序列第1大数

故表达式为：(2-1)*2! + (2-1)*1! + (1-1)*0! + 1 = 4

这后面这个1一定要加，因为前面算的都是比该数小的数，加上这个1，才是该数是第几大数。

2！表示当时当前位后面还有两位，全排列有2！种