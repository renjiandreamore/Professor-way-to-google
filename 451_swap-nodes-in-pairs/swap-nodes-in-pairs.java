/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-10-03 23:01
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next!= null && head.next.next != null){
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;
            
            head.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            
            head = node1;
        }
        
        return dummy.next;
    }
}