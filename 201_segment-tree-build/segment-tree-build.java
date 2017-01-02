/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/segment-tree-build
@Language: Java
@Datetime: 16-11-11 13:31
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        // if(start == end){
        //     return this;
        // }
        if(start > end) return null;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        
        helper(start, end, root);
        return root;
        
    }
    
    public void helper(int start, int end, SegmentTreeNode root){
        if(start == end){
            return;
        }
        SegmentTreeNode left = new SegmentTreeNode(start, (start + end)/2);
        SegmentTreeNode right = new SegmentTreeNode((start + end)/2 + 1, end);
        
        root.left = left;
        root.right = right;
        
        helper(start, (start + end)/2, left);
        helper((start + end)/2 + 1, end, right);
    }
}