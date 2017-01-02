/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Java
@Datetime: 16-10-05 14:53
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    ListNode cur;
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null){
            return null;
        }
        
        cur = head;
        int size = getLength(head);
        return helper(size);
        
    }
    
    public TreeNode helper(int size){
        if(size <= 0){
            return null;
        }
        
        TreeNode left = helper(size/2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(size - size/2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public int getLength(ListNode head){
        int len = 0;
        if(head == null){
            return len;
        }
        
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
    
}
