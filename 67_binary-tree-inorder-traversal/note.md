```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Markdown
@Datetime: 16-08-14 19:58
```

从根节点一直向左找，找找找找到最下面的左节点{
		1. 然后其实他的左节点为null， 
		2. 然后退出循环找到他（自己的根）
		3. 然后再指向它的右
}