```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Markdown
@Datetime: 16-09-13 01:13
```

直到找到fast slow 重合的那一点起：
		fast 比 slow 多走了 slow 从起点走到重合地点的步骤n。
		但是fast是从head.next走起，所以其实如果fast从head走起，那相当于fast 比 slow多走了n+1步、也说明换有n+1个元素。
		于是让head从头走起，slow往后继续每走一步。当head走n步走到slow重合所在地时，slow在head之前一步。于是是slow.next = head;
		返回head即可。