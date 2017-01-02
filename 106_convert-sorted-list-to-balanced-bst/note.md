```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Markdown
@Datetime: 16-10-05 14:53
```

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
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    
    ListNode currentNode;
    private int getLength(ListNode head){
        int l = 0;
        while(head != null){
            head = head.next;
            l++;
        }
        return l;
    } 
     
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int size = getLength(head);
        currentNode = head;
        return sortedListToBSTHelper(size);
    }
    
    private TreeNode sortedListToBSTHelper(int size){
        if(size <= 0){
            return null;
        }
        
        TreeNode left = sortedListToBSTHelper(size/2);
        TreeNode root = new TreeNode(currentNode.val);
        currentNode = currentNode.next;
        TreeNode right = sortedListToBSTHelper(size - size/2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
