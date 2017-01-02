```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Markdown
@Datetime: 16-04-22 08:28
```

无返回值类型可简单写为：

 public int maxPathSum2(TreeNode root) {
        // resultType result = helper(root);
        // return result.singlePath;
        if(root == null){
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(Math.max(left, right),0);
    }