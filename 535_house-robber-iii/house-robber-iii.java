/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/house-robber-iii
@Language: Java
@Datetime: 16-11-27 21:58
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        int[] res = func(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] func(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        
        int[] left = func(root.left);
        int[] right = func(root.right);
        
        int[] res = new int[2];
        
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        
        return res;
    }
}