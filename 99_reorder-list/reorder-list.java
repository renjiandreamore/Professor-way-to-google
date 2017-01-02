/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-09-06 16:07
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
 
 //融合了翻转、找中点、merge 2 lists 的综合实战。
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    } 
    
    private void merge(ListNode head1, ListNode head2){
        int index = 0;
        ListNode dummy = new ListNode(0);
        while(head1 != null && head2 != null){
            if(index % 2 == 0){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            index ++;
            dummy = dummy.next;
        }
        if(head2 != null){
            dummy.next = head2;
        }else{
            dummy.next = head1;
        }
    }
    
    private ListNode findMedian(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return;
        }
        
        ListNode tail = findMedian(head);
        ListNode reversed = reverse(tail.next);
        tail.next = null;
        merge(head, reversed);
        
    }
}
