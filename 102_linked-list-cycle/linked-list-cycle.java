/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/linked-list-cycle
@Language: Java
@Datetime: 16-09-06 17:32
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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
