```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Markdown
@Datetime: 16-03-13 19:51
```

不能写从0开始，要从末尾开始
因为如果是【1，3，4，6】 【2，5】， 从头开始会改变3，4，6的值，这样输出会变成1 2 2 2 5

而如果从末尾开始，因为末尾有空格， 为0， 所以不会改变当前找到的那个i的值 ，要改变的值已经被用过，挪到了末尾，从后往前。