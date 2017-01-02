/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 16-04-22 08:28
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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        resultType result = helper(root);
        return result.singlePath;
        // if(root == null){
        //     return 0;
        // }
        // int left = maxPathSum2(root.left);
        // int right = maxPathSum2(root.right);
        // return root.val + Math.max(Math.max(left, right),0);
    }
    public resultType helper(TreeNode root){
        if(root == null){
            return new resultType(0);
        }
        // if(root.left == null && root.right == null){
        //     return new resultType(root.val);
        // }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, root.val);
        
        return new resultType(singlePath);
        
    }
}
class resultType{
    int singlePath;
    public resultType(int singlePath){
        this.singlePath = singlePath;
    }
}