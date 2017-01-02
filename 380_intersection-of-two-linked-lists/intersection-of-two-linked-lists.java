/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/intersection-of-two-linked-lists
@Language: Java
@Datetime: 16-12-17 20:19
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        HashSet<ListNode> set = new HashSet<>();
        set.add(headA);
        while(nodeA.next != null){
            set.add(nodeA.next);
            nodeA = nodeA.next;
        }
        
        while(nodeB.next != null){
            if(set.contains(nodeB)){
                return nodeB;
            }else if(set.contains(nodeB.next)){
                return nodeB.next;
            }
            nodeB = nodeB.next;
        }
        
        return null;
    }  
}