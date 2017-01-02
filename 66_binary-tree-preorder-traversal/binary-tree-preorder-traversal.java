/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 16-08-14 19:38
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        // return res;
        
        //non-recursion
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
       
    //   stack.push(root);
    //   while(!stack.isEmpty()){
    //       TreeNode node = stack.pop();
    //       res.add(node.val);
    //       if(node.right!=null){
    //           stack.push(node.right);
    //       }
    //       if(node.left!=null){
    //           stack.push(node.left);
    //       }
    //   }
       return res;
    }
    
    
}