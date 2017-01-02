```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/invert-binary-tree
@Language: Markdown
@Datetime: 16-08-14 17:48
```

非递归方法是先把所有左节点打到stack里
	然后一层一层往上走，reverse，但凡找到有右节点{
			把右节点打入stack，开始找他的左节点，继续打入
				继续翻转
					直到结束
	}
	再往上走，翻转，找到左节点继续重复上面步骤。