/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-09-05 19:30
*/

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        // if(head == null){
        //     return head;
        // }
        
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // head = dummy;
        
        // for(int i = 1; i < m; i++){
        //     // if(head == null){           //why? n,m在链表范围以外的情况
        //     //     return null;
        //     // }
        //     head = head.next;
        // }
        
        // ListNode pre = head;
        // ListNode M = head.next;
        // ListNode N = M, postN = M.next;
        
        // for(int i = m; i < n; i++){
        //     // if(postN == null){
        //     //     return null;
        //     // }
        //     ListNode temp = postN.next;
        //     postN.next = N;
        //     N = postN;
        //     postN = temp;
        // }
        
        // M.next = postN;
        // pre.next = N;
        
        // return dummy.next;
        
        
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for(int i = 1; i < m; i++){ //循环m-1次，把head放置于m之前
            head = head.next;
        }
        
       
        ListNode M  = head.next;
        ListNode N = M;
        ListNode postN = M.next;
        
        for(int i = m; i < n; i++){
            ListNode temp = postN.next;
            postN.next = N;
            N = postN;
            postN = temp;
        }
        
        head.next = N;
        M.next = postN;
        
        return dummy.next;
        
    }
}