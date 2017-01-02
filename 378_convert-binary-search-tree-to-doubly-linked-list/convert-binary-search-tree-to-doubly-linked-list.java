/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-10-06 13:59
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null){
            return null;
        }
        
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode pre = dummy;
        DoublyListNode crt = dummy;
        
        
        ArrayList<Integer> res = traverse(root);
        
        for(int i : res){
            DoublyListNode d = new DoublyListNode(i);
            d.prev = pre;
            crt.next = d;
            crt = crt.next;
            pre = pre.next;
        }
        
        return dummy.next;
        
    }
    
    public ArrayList<Integer> traverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);  //打入的其实是每个根节点
                curt = curt.left;
            }
            curt = stack.peek();
            stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}
