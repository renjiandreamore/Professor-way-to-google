```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Markdown
@Datetime: 16-04-02 20:57
```

left指0应该在的位置
right指2应该在的位置
i找0或者2，遇到1跳过

凡是i遇到2，全部交换放到→_→最右，i不增加， right--
凡是i遇到1，全部和left交换，left++， i也++