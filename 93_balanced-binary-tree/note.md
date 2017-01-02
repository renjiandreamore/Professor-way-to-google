```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Markdown
@Datetime: 16-04-22 08:06
```

-1表示不是平衡二叉树。 已有-1 表示左边（右边）子树已经是-1，不用再看了。省时间。 

若算到最后没有-1，maxDepth可算出最大深度。 isBalanced函数检查，maxDepth是否是-1（若是-1：非平衡二叉树； 若不是，不用看depth是多少，直接得出是平衡二叉树）


没有返回“类”的代码可表示为：


/**

 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root) != -1;
    }
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(Math.abs(left-right) > 1 || left == -1 || right == -1){
            return -1;
        }
        
        
        return Math.max(left, right) + 1;
    }
}