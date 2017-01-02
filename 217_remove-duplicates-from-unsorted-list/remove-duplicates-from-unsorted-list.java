/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-unsorted-list
@Language: Java
@Datetime: 16-10-03 22:42
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else{
                set.add(head.next.val);
                head = head.next;
            }
        }
        
        return dummy.next;
    }  
}