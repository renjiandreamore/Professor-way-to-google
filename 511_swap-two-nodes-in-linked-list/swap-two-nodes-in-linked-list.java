/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-10-04 20:34
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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        
        //swap 两个， 需要知道prev1 prev2， node1 node2， 和其中一个node的after
        //这样就不会没有指针指向他们，不会被回收。
        //corner case： 是否v1 v2 都在ll里，不在则不swap
        //               
        //              是否交换的v1 v2相连：
        //                              是否v1 在 v2 后面
        //              相连一种解法，不相连另外一种解法
        
        
        
        if(head == null || v1 == v2){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev1 = null, prev2 = null;
        ListNode cur = dummy;
        
        while(cur.next != null){
            if(cur.next.val == v1){
                prev1 = cur;
            }else if(cur.next.val == v2){
                prev2 = cur;
            }
            cur = cur.next;
        }
        
        if(prev1 == null || prev2 == null){
            return head;
        }
        
        if(prev2.next == prev1){
            ListNode tmp = prev2;
            prev2 = prev1;
            prev1 = tmp;
        }
        
        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        ListNode afterNode2 = node2.next;
        
        if(prev1.next == prev2){
            prev1.next = node2;
            node2.next = node1;
            node1.next = afterNode2;
        }
        else{
            prev1.next = node2;
            node2.next = node1.next;
        
            node1.next = afterNode2;
            prev2.next = node1;
        }
        
        
        return dummy.next;
    }
}