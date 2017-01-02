/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/segment-tree-build-ii
@Language: Java
@Datetime: 16-11-12 16:49
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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return null;
        }
        return helper(A, 0, A.length - 1);
    }
    
    public SegmentTreeNode helper(int[] A, int start, int end){
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        
        int mid = (start + end) / 2;
        SegmentTreeNode left = helper(A, start, mid);
        SegmentTreeNode right = helper(A, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        root.max = Math.max(left.max, right.max);
        
        return root;
    }
}