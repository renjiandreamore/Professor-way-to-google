/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 16-08-14 19:58
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
    //     Traverse(root, res);
       
    //     return res;
    // }
    // public void Traverse(TreeNode root, ArrayList<Integer> res){
    //     if(root == null){
    //         return;
    //     }
    //     Traverse(root.left, res);
    //     res.add(root.val);
        
    //     Traverse(root.right, res);
    
        TreeNode curt = root;
        while(curt != null || !stack.isEmpty()){
            while(curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            TreeNode T = stack.pop();
            res.add(T.val);
            curt = T.right;
        }
        return res;
        
    }
    
    
}