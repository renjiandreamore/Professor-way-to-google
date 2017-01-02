/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 16-10-03 23:45
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
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val + l2.val < 10){
                l1.val = l1.val + l2.val;
            }else{
                
                if(l1.next != null){
                    l1.next.val = l1.next.val + 1;
                    l1.val = (l1.val + l2.val) % 10;
                }
                if(l1.next == null){
                    l1.next = new ListNode(1);
                    l1.val = (l1.val + l2.val) % 10;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        if(l1 != null){
            return dummy.next;
        }
        if(l2 != null){
            pre.next = l2;
        }
        
        return dummy.next;
    }
}