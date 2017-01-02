/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height
@Language: Java
@Datetime: 16-11-01 23:33
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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A==null || A.length == 0){
            return null;
        }
        
        return helper(A, 0, A.length - 1);
        
    }  
    
    public TreeNode helper(int[] A, int start, int end){
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, start, mid-1);
        node.right = helper(A, mid+1, end);
        
        return node;
    }
}
