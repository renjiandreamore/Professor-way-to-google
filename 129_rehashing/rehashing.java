/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-09-15 14:34
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable.length <= 0){
            return hashTable;
        }
        
        int newCapacity = 2 * hashTable.length;
        ListNode[] newHash = new ListNode[newCapacity];
        
        for(int i = 0; i < hashTable.length; i++){
            while(hashTable[i] != null){
                int index = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                if(newHash[index] == null){
                    newHash[index] = new ListNode(hashTable[i].val);
                }else{
                    ListNode dummy = newHash[index];
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;

            }
        }
        return newHash;
    }
};
