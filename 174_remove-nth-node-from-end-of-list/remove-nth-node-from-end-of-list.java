/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-09-12 23:34
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
     
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        if(n <= 0 || head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        
        ListNode pre = dummy;
        while(head != null ){
            pre = pre.next;
            head = head.next;
        }
        
        pre.next = pre.next.next;
        return dummy.next;
        
        
    }
}
