```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Markdown
@Datetime: 16-09-07 18:23
```

 
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
