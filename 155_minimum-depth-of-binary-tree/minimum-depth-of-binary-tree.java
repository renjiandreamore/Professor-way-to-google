/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-depth-of-binary-tree
@Language: Java
@Datetime: 16-10-02 17:21
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
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    
    public int getMin(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        return Math.min(getMin(root.left), getMin(root.right))+1;
    }
}