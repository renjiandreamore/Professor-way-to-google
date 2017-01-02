```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Markdown
@Datetime: 16-11-03 05:28
```

1，3，2，-1，3，5，6     k=4

1. 对于从0开始的前k-1个数，保证从最高的那个，到最后新加入进来的那个，中间全是降序， 加入deque
	dq = 3,2

2.从第k-1个到最后一个数， 加入dq，还是保证从高到低降序
		2.1 inque(dq, nums[i])   --> dq = 3,2,-1
		2.2 把前k个数里最大的（也就是dq最左边的）加入res
		2.3 因为window要向右移动了，于是如果最大的数刚好是窗口最左边的(nums[i-k+1])，所以只能把它删掉。 如果最左边数不是最大的， 则不从deque里删.

3.循环调用从k-1 到 结尾
		