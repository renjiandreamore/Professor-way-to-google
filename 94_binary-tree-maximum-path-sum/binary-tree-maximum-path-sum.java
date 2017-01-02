/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-04-22 08:08
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
    // public int maxPathSum(TreeNode root) {
    //     // write your code here
    //     if(root == null){
    //         return 0;
    //     }
    //     int left = maxPathSum(root.left);
    //     int right = maxPathSum(root.right);
        
    //     return left + right + root.val; 
    // }
    
    public int maxPathSum(TreeNode root){
        // write your code here
        resultType result = helper(root);
        return result.sumPath;
        
        
    }
    public resultType helper(TreeNode root){
        if(root == null){
            return new resultType(0, Integer.MIN_VALUE);//singlepath可以为0因为小于0的我们就不要了。但sum不能为0因为sum可以为负数  //；
        }
        
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        
        int sumPath = Math.max(left.sumPath, right.sumPath);//先比一下左子树和右子树sumPath哪个大，因为有可能更大的那个比算上root的两个si//nglePath的和加起来更大.
        sumPath = Math.max(left.singlePath + right.singlePath + root.val, sumPath);
        
        return new resultType(singlePath, sumPath);
    }
}
class resultType{
    int singlePath, sumPath;
    public resultType(int singlePath, int sumPath){
        this.singlePath = singlePath;
        this.sumPath = sumPath;
    }
}