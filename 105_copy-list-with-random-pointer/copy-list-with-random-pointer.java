/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-09-08 19:55
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null || head.next == null ){
            return new RandomListNode(head.label);
        }
        
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        
        while(head!=null){
            if(map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
        
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
        
            pre = newNode;
            head = head.next;
        }
        
        
        
        return dummy.next;
        
    }
}
/*
* 这个版本更容易懂
*
*/

// public class Solution {
//     private void copyNext(RandomListNode head) {
//         while (head != null) {
//             RandomListNode newNode = new RandomListNode(head.label);
//             newNode.random = head.random;
//             newNode.next = head.next;
//             head.next = newNode;
//             head = head.next.next;
//         }
//     }

//     private void copyRandom(RandomListNode head) {
//         while (head != null) {
//             if (head.next.random != null) {
//                 head.next.random = head.random.next;
//             }
//             head = head.next.next;
//         }
//     }

//     private RandomListNode splitList(RandomListNode head) {
//         RandomListNode newHead = head.next;
//         while (head != null) {
//             RandomListNode temp = head.next;
//             head.next = temp.next;
//             head = head.next;
//             if (temp.next != null) {
//                 temp.next = temp.next.next;
//             }
//         }
//         return newHead;
//     }

//     public RandomListNode copyRandomList(RandomListNode head) {
//         if (head == null) {
//             return null;
//         }
//         copyNext(head);
//         copyRandom(head);
//         return splitList(head);
//     }
// }