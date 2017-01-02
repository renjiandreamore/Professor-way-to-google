/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-10-03 21:48
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
    ArrayList<Integer> res;
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        // ArrayList<Integer> res = new ArrayList<Integer>();
        //Stack<TreeNode> stack = new Stack<TreeNode>();
    //     Traverse(root, res);
        
    //     ArrayList<Integer> s = new ArrayList<>();
    //     for(int i : res){
    //         if(i >= k1 && i <= k2){
    //             s.add(i);
    //         }
    //     }
    //     return s;
    // }
    // public void Traverse(TreeNode root, ArrayList<Integer> res){
    //     if(root == null){
    //         return;
    //     }
    //     Traverse(root.left, res);
    //     res.add(root.val);
        
    //     Traverse(root.right, res);
        res = new ArrayList<>();
        helper(root, k1, k2);
        return res;
    }
    
    public void helper(TreeNode root, int k1, int k2){
        if(root == null){
            return;
        }
        
        if(root.val > k1){
            helper(root.left, k1, k2);
        }
        
        if(root.val >= k1 && root.val <= k2){
            res.add(root.val);
        }
        
        if(root.val < k2){
            helper(root.right, k1, k2);
        }
    }
}