/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 16-10-03 04:12
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        
        helper(res, path, root.val, target, root);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> path, int sum, int target, TreeNode root){
        if(root.left == null && root.right == null){
            if(sum == target){
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if(root.left != null){
            path.add(root.left.val);
            helper(res, path, sum + root.left.val, target, root.left);
            path.remove(path.size()-1);
        }
        
        if(root.right != null){
            path.add(root.right.val);
            helper(res, path, sum + root.right.val, target, root.right);
            path.remove(path.size()-1);
        }
        //res.add(new ArrayList<Integer>(path));
    }
}