```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Markdown
@Datetime: 16-03-30 19:48
```

oneOfresult 要写在sum == 0 或者 while 里面，这样每次只只存一个 和为0的结果，然后加到res里，然后下次继续计算新的和为0的结果前它会清零，这样就不会保存之前的结果了， 比如结果为{[-1,0,1],[-1,-1,2]}, 就不会写为{[-1,0,1,-1,-1,2], [ -1, 0, 1, -1, -1, 2]}; 

主题是先排序，这样从小到大排好：
确定第一个点，确定left 和right，首尾指针向中间移动，若sum<0, 表示数字还需增大，于是left++， vice versa

注意要写while（left < right）的条件