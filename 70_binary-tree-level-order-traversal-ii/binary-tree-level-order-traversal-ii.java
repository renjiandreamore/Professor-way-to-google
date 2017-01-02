/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 16-07-25 05:06
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        
        while(!Q.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = Q.size();
            for(int i = 0; i < size; i++){
                TreeNode head = Q.poll();
                level.add(head.val);
                if(head.left!=null){
                    Q.offer(head.left);
                }
                if(head.right!=null){
                    Q.offer(head.right);
                }
            }
            res.add(level);
            
        }
        Collections.reverse(res);
        return res;
    }
}