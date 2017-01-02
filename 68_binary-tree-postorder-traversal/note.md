```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Markdown
@Datetime: 16-08-16 16:54
```

一直往左走，走到最底下，pop，往上
如果有右儿子，push到stack
回去，
再往上，循环。