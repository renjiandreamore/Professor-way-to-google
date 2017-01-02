```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Markdown
@Datetime: 16-10-16 00:59
```

因为Maximum Subarray这个问题，我们将其转化为两个前缀的差的问题。
原问题抽象出来是，找到 A[i] + A[i + 1] + A[i + 2] + ...... + A[j] 使得和最大。
现在我们定义前缀和 Sum[i] = A[1] + A[2] + A[3] + ... + A[i]
那么 A[i] + A[i + 1] + A[i + 2] + ...... + A[j] = (A[1] + A[2] + A[3] + ... + A[j]) - (A[1] + A[2] + A[3] + ... + A[i - 1]) = Sum[j] - Sum[i - 1]

也就是在Sum数组中找到两个值他们的差最大。
在Best Time To Buy And Sell Stock问题中，也是找prices[j] - prices[i]差值最大。

所以这两个问题是相似的。



从头开始到nums[i]的和是固定的，只有当某个点前缀和最小，它后半部分和才能最大。
