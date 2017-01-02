```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-lists
@Language: Markdown
@Datetime: 16-10-04 04:57
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
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head1 = l1, head2 = l2, node = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        
        if(head2 != null){
            dummy.next = head2;
        }
        else{
            dummy.next = head1;
        }
        
        return node.next;
    }
}