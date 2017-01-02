/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 16-09-12 23:17
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
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
        if(head1 != null){//while
            dummy.next = head1;
        }
        else{
            dummy.next = head2;
        }
        return tail.next;
    } 
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    
    
    
    /*
    quick sort version
    */
    // public ListNode findMiddle(ListNode head){
    //     ListNode slow = head, fast = head.next;
    //     while(fast!=null && fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
    
    // public ListNode sortList(ListNode head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     ListNode mid = findMiddle(head);
    //     ListNode leftDummy = new ListNode(0);
    //     ListNode rightDummy = new ListNode(0);
    //     ListNode midDummy = new ListNode(0);
        
    //     ListNode leftTail = leftDummy, rightTail = rightDummy, midTail = midDummy;
        
    //     while(head!=null){
    //         if(head.val < mid.val){
    //             leftTail.next = head;
    //             leftTail = head;
    //         }else if(head.val > mid.val){
    //             rightTail.next = head;
    //             rightTail = head;
    //         }else{
    //             midTail.next = head;
    //             midTail = head;
    //         }
    //         head = head.next;
    //     }
        
    //     leftTail.next = null; rightTail.next = null; midTail.next = null;
        
    //     ListNode left = sortList(leftDummy.next);
    //     ListNode right = sortList(rightDummy.next);
        
    //     return concat(left, midDummy.next, right);
    // }
    
    // public ListNode concat(ListNode left, ListNode mid, ListNode right){
    //     ListNode dummy = new ListNode(0);
    //     ListNode tail = dummy;
        
    //     tail.next = left;
    //     tail = getTail(tail);
        
    //     tail.next = mid;
    //     tail = getTail(tail);
        
    //     tail.next = right;
    //     tail = getTail(tail);
        
    //     return dummy.next;
    // }
    
    // public ListNode getTail(ListNode head){
    //     if(head == null){
    //         return null;
    //     }
        
    //     while(head.next != null){
    //         head = head.next;
    //     }
    //     return head;
    // }
    
    
}
