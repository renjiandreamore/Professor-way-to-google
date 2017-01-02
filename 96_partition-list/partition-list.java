/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-09-05 19:58
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while(head != null){
            if(head.val<x){
                left.next = head;
                left = head;
            }else{
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next; 
        //rightDummy.next = null;
        return leftDummy.next;
    }
}
