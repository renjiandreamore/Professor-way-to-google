/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 16-12-14 23:23
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
                
            }
            result.add(level);
        }
        return result;
//         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
// 		if(root == null){
// 			return res;
// 		}
		
// 		int maxDepth = 0;
// 		while(true){
// 			ArrayList<Integer> level = new ArrayList<Integer>();
// 			DFS(root, level, 0, maxDepth);
// 			maxDepth++;
// 			if(level.size() == 0){
// 				break;
// 			}
// 			res.add(level);
// 		}
// 		return res;
//     }
//     public void DFS(TreeNode root, ArrayList<Integer> level, int curDepth, int maxDepth){
// 		if(root == null || curDepth > maxDepth){
// 			return;
// 		}
// 		if(curDepth == maxDepth){
// 			level.add(root.val);
// 			return;
// 		}
// 		DFS(root.left, level, curDepth+1, maxDepth);
// 		DFS(root.right, level, curDepth+1, maxDepth);

	}
	
}