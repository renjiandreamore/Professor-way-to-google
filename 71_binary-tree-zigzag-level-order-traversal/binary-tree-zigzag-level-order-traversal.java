/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-08-16 19:58
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        /*
		 * version 1 BFS
		 */
// 		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// 		if(root == null){return res;}
		
// 		Stack<TreeNode> st1 = new Stack<TreeNode>();
// 		Stack<TreeNode> st2 = new Stack<TreeNode>();
// 		Stack<TreeNode> tmp;
// 		st1.push(root);
// 		Boolean order = true;
		
// 		while(!st1.isEmpty()){
		    
// 		    ArrayList<Integer> lev = new ArrayList<Integer>();
// 		    while(!st1.isEmpty()){
// 		        TreeNode level = st1.pop();
// 		        lev.add(level.val);
// 		        if(order){
// 		            if(level.left!=null){
// 		                st2.push(level.left);
// 		            }
// 		            if(level.right != null){
// 		                st2.push(level.right);
// 		            }
// 		        }else if(!order){
// 		            if(level.right != null){
// 		                st2.push(level.right);
// 		            }
// 		            if(level.left != null){
// 		                st2.push(level.left);
// 		            }
// 		        }
		        
// 		    }
// 		    tmp = st1;
// 		    st1 = st2;
// 		    st2 = tmp;
// 		    res.add(lev);
// 		    order = !order;
		    
// 		}
		
		
// 		return res;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        boolean normalOrder = true;
        st1.push(root);
        
        while(!st1.isEmpty()){
            ArrayList<Integer> levelResult = new ArrayList<Integer>();
            while(!st1.isEmpty()){
                TreeNode node = st1.pop();
                levelResult.add(node.val);
                if(normalOrder){
                    if(node.left != null){
                        st2.push(node.left);
                    }
                    if(node.right != null){
                        st2.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        st2.push(node.right);
                    }
                    if(node.left != null){
                        st2.push(node.left);
                    }
                }
            }
            temp = st1;
            st1 = st2;
            st2 = temp;
            normalOrder = !normalOrder;
            res.add(levelResult);
        }
        return res;
    }
}