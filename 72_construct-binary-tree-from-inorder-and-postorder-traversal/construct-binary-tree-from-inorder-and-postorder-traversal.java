/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Java
@Datetime: 16-10-03 03:23
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder.length != postorder.length){
            return null;
        }
        
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int instart, int inend, int[] postorder, int postart, int posend){
        
        if(instart > inend){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[posend]);
        int rootPosition = findInorderRoot(inorder, instart, inend, postorder[posend]);
        
        root.left = buildTreeHelper(inorder, instart, rootPosition - 1, postorder, postart, postart + rootPosition - instart - 1);
        
        root.right = buildTreeHelper(inorder, rootPosition + 1, inend, postorder, posend-(inend - rootPosition), posend - 1);
        
        return root;
        
    }
    
    public int findInorderRoot(int[] inorder, int instart, int inend, int value){
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
}