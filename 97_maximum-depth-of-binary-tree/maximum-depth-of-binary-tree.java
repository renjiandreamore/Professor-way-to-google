/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/maximum-depth-of-binary-tree
@Language: Java
@Datetime: 16-06-07 01:42
*/

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
     * @return: An integer.
     */
    private int depth;
    public int maxDepth(TreeNode root) {
        // write your code here
        depth = 0;
        Help(root, 1);
        return depth;
        
        
    }
    public void Help(TreeNode node, int curtDepth){
        if(node == null){
            return;
        }
        if(curtDepth > depth){
            depth = curtDepth;
        }
        
        Help(node.left, curtDepth + 1);
        Help(node.right, curtDepth + 1);
    }
}