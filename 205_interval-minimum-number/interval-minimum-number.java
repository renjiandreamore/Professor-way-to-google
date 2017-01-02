/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Java
@Datetime: 16-11-13 17:14
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class SegmentTree{
    int start, end;
    int min;
    SegmentTree left;
    SegmentTree right;
    public SegmentTree(int start, int end, int min){
        this.start = start;
        this.end = end;
        this.min = min;
        this.left = null;
        this.right = null;
    }
}
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0 || queries == null || queries.size()==0){
            return res;
        }
        
        SegmentTree root = build(A, 0, A.length - 1);
        
        for(Interval i : queries){
            int start = i.start;
            int end = i.end;
            
            int min = query(root, start, end);
            res.add(min);
        }
        
        return res;
    }
    
    public SegmentTree build(int[] A, int start, int end){
        // if(A == null || A.length == 0){
        //     return null;
        // }
        if(start == end){
            return new SegmentTree(start, end, A[start]);
        }
        SegmentTree root = new SegmentTree(start, end, Integer.MAX_VALUE);
        int mid = (start + end)/2;
        
        SegmentTree left = build(A, start, mid);
        SegmentTree right = build(A, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        root.min = Math.min(left.min, right.min);
        
        return root;
    }
    
    public int query(SegmentTree root, int start, int end){
        if(root.start == start && root.end == end){
            return root.min;
        }
        
        int mid = (root.start + root.end) / 2;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        
        
        if(start <= mid){
            if(end > mid){
                left = query(root.left, start, mid);
            }else{
                left = query(root.left, start, end);
            }
        }
        
        if(end >= mid + 1){
            if(start < mid + 1){
                right = query(root.right, mid + 1, end);
            }else{
                right = query(root.right, start, end);
            }
        }
        
        return Math.min(left, right);
    }
}