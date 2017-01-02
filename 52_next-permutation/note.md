```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Markdown
@Datetime: 16-10-24 01:19
```

找到最后一次增长的位置i（表示其后都为下降） （意味着要在这个点改变数值）（改变的则是其后下降的数值里第一个比他大的值）
		于是找到它后面第一个比他大的值，二者交换
		（此时交换后的i的地方放了正确的值）， 可是其后还是从大到小逐一减少。但是按理来说，交换以后，其后部正好应该从小到大，于是reverse一下就可以了。