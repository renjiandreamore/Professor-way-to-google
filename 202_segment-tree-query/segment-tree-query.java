/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/segment-tree-query
@Language: Java
@Datetime: 16-11-11 14:33
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
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && end == root.end){
            return root.max; 
        }
        
        int mid = (root.start + root.end) / 2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        //left
        if(start <= mid){
            if(end > mid){
                leftMax = query(root.left, start, mid);
            }else{
                leftMax = query(root.left, start, end);
            }
        }
        
        //right
        if(end >= mid + 1){
            if(start < mid + 1){
                rightMax = query(root.right, mid + 1, end);
            }else{
                rightMax = query(root.right, start, end);
            }
        }
        
        return Math.max(leftMax, rightMax);
    }
}