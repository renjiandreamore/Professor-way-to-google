/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/segment-tree-modify
@Language: Java
@Datetime: 16-11-11 14:51
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index){
            root.max = value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <= mid){
            modify(root.left, index, value);
        }
        
        if(mid + 1 <= index && index <= root.end){
            modify(root.right, index, value);
        }
        
        root.max = Math.max(root.left.max, root.right.max);
    }
}