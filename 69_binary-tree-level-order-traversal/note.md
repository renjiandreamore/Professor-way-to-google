```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Markdown
@Datetime: 16-12-14 23:23
```

知道最后一层的每一个node的左右儿子都为null才结束


size 要写成 int isze = queue.size();
不能直接在for循环里写queue.size();
会变成[1,2,3,4],[5,6],[7]


//理解1 queue + 1dummy node 写法