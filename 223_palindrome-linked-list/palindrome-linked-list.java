/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/palindrome-linked-list
@Language: Java
@Datetime: 16-10-04 05:48
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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        // 单链表，没有prev指针， 不能一head 一 tail，往回靠拢判断是否相等
        // 只能把后半段reverse， 一起往右走判断是否相等。
        if(head == null){
            return true;
        }
        
        ListNode mid = findMid(head);
        mid.next = reverse(mid.next);
        
        ListNode node1 = head;
        ListNode node2 = mid.next;
        
        while(node1 != null && node2 != null && node1.val == node2.val){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2 == null;
    }
    
    ListNode findMid(ListNode head){
        if(head == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        
       while(head != null){
          ListNode tmp = head.next;    //需要有指针指向head.next, 否则会被回收
          head.next = prev;
          prev = head;
          head = tmp;
       }
        
       return prev;
        
    }
}