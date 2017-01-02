/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 16-04-22 08:06
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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        resultType result = helper(root);
        return result.isbalanced;
    }
    public resultType helper(TreeNode root){
        if(root == null){
            return new resultType(true, 0);
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        if(left.maxDepth == -1 || right.maxDepth == -1){
            return new resultType(false, -1);
        }
        
        if(Math.abs(left.maxDepth - right.maxDepth) > 1 ){
            return new resultType(false, -1);
        }
        return new resultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}

class resultType{
    boolean isbalanced;
    int maxDepth;
    public resultType(boolean isbalanced, int maxDepth){
        this.isbalanced = isbalanced;
        this.maxDepth = maxDepth;
    }
}