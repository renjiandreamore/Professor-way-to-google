/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 16-10-05 15:43
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ArrayList<Integer> res = traverse(root);
        if(!res.contains(A.val) || !res.contains(B.val)){
            return null;
        }
        
        return helper(root, A, B);
    }
    
    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
        
        if(root == null || root == A || root == B){
            return root;
        }
        
        // ArrayList<Integer> res = traverse(root);
        // if(!res.contains(A.val) || !res.contains(B.val)){
        //     return null;
        // }
        
        
        
        TreeNode left = helper(root.left, A ,B);
        TreeNode right = helper(root.right, A, B);
        
        if(left!=null && right !=null){
            return root;
        }else if(left!= null){
            return left;
        }else if(right!= null){
            return right;
        }
        return null;
    }
    
    public ArrayList<Integer> traverse(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        
        res.addAll(traverse(root.left));
        res.addAll(traverse(root.right));
        res.add(root.val);
        
        return res;
    }
}