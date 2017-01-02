/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-10-03 04:59
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
class ResultType{
    int depth;
    boolean isFull, isComplete;
    public ResultType(int depth, boolean isFull, boolean isComplete){
        this.depth = depth;
        this.isFull = isFull;
        this.isComplete = isComplete;
    }
}
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        ResultType res = helper(root);
        return res.isComplete;
    }
    
    public ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, true, true);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(!left.isComplete){
            return new ResultType(-1, false, false);
        }
        
        else if(left.depth == right.depth){
            if(!left.isFull || !right.isComplete){
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, right.isFull, true);
        }
        
        else if(left.depth == right.depth + 1){
            if(!right.isFull){
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, false, true);
        }
        
        else{
            return new ResultType(-1, false, false);
        }
    }
}