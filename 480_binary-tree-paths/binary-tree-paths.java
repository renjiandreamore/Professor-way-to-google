/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 16-12-17 21:40
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<>();
        String path = "";
        helper(root, res, path);
        return res;
    }
    
    public void helper(TreeNode root, List<String> res, String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            path += String.valueOf(root.val);
            res.add(path);
            return;
        }
        
        path += String.valueOf(root.val) + "->";
        helper(root.left, res, path);
        
        helper(root.right, res, path);
        
    }
}