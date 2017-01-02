/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/segment-tree-query-ii
@Language: Java
@Datetime: 16-11-12 17:22
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null || start > end || start > root.end ){
            return 0;
        }
        // if(end > root.end && start < root.end){
        //     return query(root, start, root.end);
        // }
        
        if(start <= root.start && end >= root.end){
            return root.count;
        }
        
        int result = 0;
        
        int mid = (root.start + root.end) / 2;
        int left = 0;
        int right = 0;
        
        if(start <= mid){
            if(end > mid){
                left = query(root.left, start, mid);
            }else{
                left = query(root.left, start, end);
            }
        }
        
        if(end >= mid + 1){
            if(start < mid + 1){
                right = query(root.right, mid+1, end);
            }else{
                right = query(root.right, start, end);
            }
        }
        
        result = left + right;
        return result;
    }
}