```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Markdown
@Datetime: 16-04-07 00:13
```

(http://file:///Users/davidren/Desktop/149.pic.jpg)(file:///Users/davidren/Desktop/149.pic.jpg)

A[start] < A[mid] 是一种情况{
	表示折过去（到末尾）的部分少于原有部分
	再分情况讨论，递归
}

A[start] >= A[mid] 是另外一种情况{
	表示折过去的部分多于保留的后半部分
	再分情况讨论，递归
}