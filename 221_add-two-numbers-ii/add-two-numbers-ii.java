/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/add-two-numbers-ii
@Language: Java
@Datetime: 16-10-04 06:15
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        
        return reverse(addList(head1, head2));
    }  
    
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
    
    public ListNode addList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode prev = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val + l2.val < 10){
                l1.val = l1.val + l2.val;
            }
            else{
                if(l1.next != null){
                    l1.next.val = l1.next.val + 1;
                    l1.val = (l1.val + l2.val) % 10;
                }
                else{
                    ListNode tmp = new ListNode(1);
                    l1.next = tmp;
                    l1.val = (l1.val + l2.val) % 10;
                }
            }
            
            l1 = l1.next;
            l2 = l2.next;
            prev = prev.next;
        }
        
        if(l2 != null){
            prev.next = l2;
        }
        
        return dummy.next;
        
        
    }
}