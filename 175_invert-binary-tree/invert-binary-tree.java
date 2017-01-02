/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/invert-binary-tree
@Language: Java
@Datetime: 16-08-14 17:48
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
    public Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public void invertBinaryTree(TreeNode root) {
        
        // write your code here
        if(root == null){
            return;
        }
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;
        
        // invertBinaryTree(root.right);
        // invertBinaryTree(root.left);
        
        //non-recurssion
        TreeNode tmp = root;
        while(!stack.isEmpty() || tmp != null){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            TreeNode T = stack.pop();
            tmp = T.right;
            reverse(T);
        }
        
    }
    public void reverse(TreeNode root){
        if(root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}