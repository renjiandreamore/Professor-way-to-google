/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 16-08-16 16:54
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        // res.addAll(postorderTraversal(root.left));
        // res.addAll(postorderTraversal(root.right));
        // res.add(root.val);
        // return res;
        
        //non-recursion
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curt = root;
        TreeNode prev = null;
        stack.push(root);
        
        while(!stack.isEmpty()){
            curt = stack.peek();
            if(prev == null || prev.left == curt || prev.right == curt){
                if(curt.left != null){
                    stack.push(curt.left);
                }else if(curt.right != null){
                    stack.push(curt.right);
                }
            }else if(curt.left == prev){
                if(curt.right != null){
                    stack.push(curt.right);
                }
            }//else if(curt.right == prev){
            //     res.add(curt.val);
            //     stack.pop();
            // }
            
            else{
                res.add(curt.val);
                stack.pop();
            }
            
            prev = curt;
        }
        
        return res;
    }
    
}