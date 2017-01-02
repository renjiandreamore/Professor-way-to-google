```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii
@Language: Markdown
@Datetime: 16-04-23 15:58
```

里层while循环 把相同value提出来，然后从第一个相同的数本身喀什删除。

删除链表只需将指针不指向它。

dummynode可以删除所有dup一个都不剩