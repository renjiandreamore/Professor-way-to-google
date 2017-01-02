/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-09-06 17:22
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    private int getLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length ++;
        }
        return length;
    } 
    
    // private ListNode findNode(ListNode head, int length, int k){
    //                 for(int i = 1; i < length - k%length ; i++){
    //                     head = head.next;  
    //                 }

    //     return head;
    // }
    
    // private ListNode merge(ListNode head1, ListNode head2){
    //     int index = 0;
    //     ListNode dummy = new ListNode(0);
    //     ListNode first = dummy;
    //     while(head1 != null && head2 != null){
    //         if(index % 2 == 0){
    //             dummy.next = head1;
    //             head1 = head1.next;
    //         }else{
    //             dummy.next = head2;
    //             head2 = head2.next;
    //         }
    //         index ++;
    //         dummy = dummy.next;
    //     }
    //     if(head2 != null){
    //         dummy.next = head2;
    //     }else{
    //         dummy.next = head1;
    //     }
    //     dummy.next.next = null;
    //     return first.next;
    // }
     
    // public ListNode rotateRight(ListNode head, int k) {
    //     // write your code here
    //     if(head == null || head.next == null){
    //         return head;
    //     }
        
    //     ListNode kFromLast = findNode(head, getLength(head), k);
    //     ListNode tail = kFromLast.next;
    //     kFromLast.next = null;
    //     return merge(tail, head);
    // }
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        int n = k % getLength(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        ListNode slow = dummy;
        ListNode fast = head;
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}