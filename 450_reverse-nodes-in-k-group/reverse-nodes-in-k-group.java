/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-10-05 23:30
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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(head == null || k <= 0){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            head = reverseNextK(head, k);
        }
        
        //System.out.println(head.val);
        return dummy.next;
        
        
        
    }
    
    public ListNode reverseNextK(ListNode head, int k){
        
        ListNode test = head;
        for(int i = 0; i < k; i++){
            if(test.next == null){
                return test;
            }
            
            test = test.next;
        }
        
        ListNode n1 = head.next;
        ListNode prev = head, crt = n1;
        for(int i = 0; i < k; i++){
            ListNode tmp = crt.next;
            crt.next = prev;
            prev = crt;
            crt = tmp;
        }
        
        head.next = prev;
        n1.next = crt;
        
        return n1;
    }
}