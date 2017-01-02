/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 16-09-07 18:23
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    // public ListNode mergeKLists(List<ListNode> lists) {  
    //     // write your code here
    //     if(lists == null || lists.size()==0){
    //         return null;
    //     }
    //     while(lists.size() > 1){
    //         List<ListNode> newList = new ArrayList<ListNode>();
    //         for(int i = 0; i + 1 < lists.size(); i+=2){
    //             ListNode merged_list = mergeTwoLists(lists.get(i), lists.get(i+1));
    //             newList.add(merged_list);
    //         }
    //         if(lists.size() % 2 ==1){
    //             newList.add(lists.get(lists.size() - 1));
    //         }
    //         lists = newList;
    //     }
    //     return lists.get(0);
    // }
    
    // // private ListNode mergeListsHelper(List<ListNode> list, int start, int end){
    // //     int mid = (start + end)/2;
        
    // //     if(start == end){
    // //         return list.get(start);
    // //     }
        
    // //     ListNode left = mergeListsHelper(list, start, mid);
    // //     ListNode right = mergeListsHelper(list, mid + 1, end);
        
    // //     return mergeTwoLists(left, right);
    // // }
    
    // private ListNode mergeTwoLists(ListNode head1, ListNode head2){
    //     ListNode dummy = new ListNode(0);
    //     ListNode cur = dummy;
        
    //     while(head1!=null && head2!=null){
    //         if(head1.val < head2.val){
    //             dummy.next = head1;
    //             head1 = head1.next;
    //         }else{
    //             dummy.next = head2;
    //             head2 = head2.next;
    //         }
    //     dummy = dummy.next;
    //     }
    //     if(head1!=null){
    //         dummy.next = head1;
    //     }else{
    //         dummy.next = head2;
    //     }
        
    //     return cur.next;
    // }
     public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists.size()==0){
            return null;
        }
        return mergeListsHelper(lists, 0, lists.size()-1);
    }
    
	
    private ListNode mergeListsHelper(List<ListNode> list, int start, int end){
        int mid = (start + end)/2;
        
        if(start == end){
            return list.get(start);
        }
		
        
        ListNode left = mergeListsHelper(list, start, mid);
        ListNode right = mergeListsHelper(list, mid + 1, end);
        
        return mergeTwoLists(left, right);
    }
    
	
    private ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
        dummy = dummy.next;
        }
        if(head1!=null){
            dummy.next = head1;
        }else{
            dummy.next = head2;
        }
        
        return cur.next;
    }

}
