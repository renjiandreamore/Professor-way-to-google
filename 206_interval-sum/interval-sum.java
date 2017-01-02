/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Java
@Datetime: 16-11-15 17:01
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class SegmentTree{
    int start, end;
    long sum;
    SegmentTree left;
    SegmentTree right;
    public SegmentTree(int start, int end, long sum){
        this.left = null;
        this.right = null;
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}

public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public SegmentTree build(int[] A, int start, int end){
        if(start > end) return null;
        if(start == end){
            return new SegmentTree(start, end, (long)A[start]);
        }
        SegmentTree root = new SegmentTree(start, end, 0x7fffffff);
    
        int mid = (start + end) / 2;
    
        root.left = build(A, start, mid);
        root.right = build(A, mid+1, end);
    
        root.sum = root.left.sum + root.right.sum;
    
        return root;
    }

    public long query(SegmentTree root, int start, int end){
        if(start == root.start && end == root.end){
            return root.sum;
        }
        
        int mid = (root.start + root.end) / 2;
        long left = 0;
        long right = 0;
        
        
        if(start <= mid){
            if(end > mid){
                left = query(root.left, start, mid);
            }else{
                left = query(root.left, start, end);
            }
        }
        
        if(end > mid){
            if(start <= mid){
                right = query(root.right, mid + 1, end);
            }else{
                right = query(root.right, start, end);
            }
        }
        
        return left + right;
    }
    
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> res = new ArrayList<>();
        if(A == null || A.length == 0 || queries == null || queries.size()==0){
            return res;
        }
        
        SegmentTree tree = build(A, 0, A.length - 1);
        for(Interval i : queries){
            int start = i.start;
            int end = i.end;
            res.add( query(tree, start, end));
        }
        
        return res;
    }
}
