/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 16-12-23 18:07
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null) return;
        
        if(lastNode!=null){
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode tmp = root.right;
        flatten(root.left);
        flatten(tmp);
    }
}