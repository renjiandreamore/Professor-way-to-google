/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-10-03 03:08
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder.length != inorder.length){
            return null;  
        }
        
        return buildTreeHelper(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int instart, int inend, int[]preorder, int prestart, int preend){
        if(prestart > preend){
            return null; //也可写成instart > inend;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findInoderRootPosition(inorder, instart, inend, preorder[prestart]);
        
        root.left = buildTreeHelper(inorder, instart, position -1, preorder, prestart + 1, position - instart + prestart);
        
        root.right = buildTreeHelper(inorder, position + 1, inend, preorder, preend - (inend - position) + 1, preend); 
        //也可写成 position - instart + prestart + 1
        
        return root;
    }
    
    public int findInoderRootPosition(int[] inorder, int start, int end, int value){
        for(int i = start; i <= end; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
}
