/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-08-16 21:26
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode later = null;
        
        while(root != null && root != p){
            if(root.val > p.val){
                later = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        if(root == null){return null;}
        if(root.right == null){return later;}
        root = root.right;
        while(root.left != null){   //这个while表示找到比p大的右边的节点
              root = root.left;     //若它还有左子节点，继续往左。
        }                           //因为  越往左越小，但都比P大                                           //就找到最小的比p大的节点
        return root;
    }
}