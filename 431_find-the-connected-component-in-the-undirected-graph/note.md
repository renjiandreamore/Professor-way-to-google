```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Markdown
@Datetime: 16-09-27 21:31
```

因为要找所有联通块，所以先把所有点遍历一遍打入hashmap，设立visited为false；

将所有false的点，bfs一遍，找到他们的所有邻居，加入res

所以需要把hashmap通过bfs函数传过去。