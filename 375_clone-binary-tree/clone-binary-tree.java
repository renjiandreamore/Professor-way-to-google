/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/clone-binary-tree
@Language: Java
@Datetime: 16-11-08 04:52
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
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        
        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);
        
         return node;
    }
}