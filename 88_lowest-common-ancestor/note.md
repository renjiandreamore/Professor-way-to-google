```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Markdown
@Datetime: 16-09-21 16:25
```

若root的左右子树刚好是AB，那么返回root；

若在root的left子树里能找到AB的公共祖先，那返回left；
若在root的right子树里能找到AB公共祖先，那返回right；

递归。分治；

等于先找祖先，自己也算是自己的祖先、再一层层往上，找到公共祖先。