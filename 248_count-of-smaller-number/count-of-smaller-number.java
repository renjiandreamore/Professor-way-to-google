/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Java
@Datetime: 16-11-16 15:40
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        // if(A == null || A.length == 0 || queries == null || queries.length == 0){
        //     return res;
        // }
        
        SegmentTree tree = build(0, 1000);
        for(int i = 0; i < A.length; i++){
            modify(tree, A[i], 1);
        }
        
        for(int i = 0; i < queries.length; i++){
            int num = 0;
            if(queries[i] > 0)
                num = query(tree, 0, queries[i] - 1);
            res.add(num);
        }
        
        return res;
    }
    
    public SegmentTree build(int start, int end){
        if(start > end) return null;
        if(start == end){
            return new SegmentTree(start, end, 0);
        }
        SegmentTree root = new SegmentTree(start, end, 0);
        
        int mid = (start + end) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        
        return root;
    }
    
    public void modify(SegmentTree root, int index, int value){
        if(root.start == index && root.end == index){
            root.count += value;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <= mid){
            modify(root.left, index, value);
        }else if(mid + 1 <= index && index <= root.end){
            modify(root.right, index, value);
        }
        
        root.count = root.left.count + root.right.count;
    }
    
    public int query(SegmentTree root, int start, int end){
        if(root.start == start && root.end == end){
            return root.count;
        }
        
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
        if(end > mid){
            if(start <= mid){
                right = query(root.right, mid + 1, end);
            }else{
                right = query(root.right, start, end);
            }
        }
        
        return left + right;
    }
}

class SegmentTree{
    int start, end;
    int count;
    SegmentTree left, right;
    public SegmentTree(int start, int end, int count){
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = null;
        this.right = null;
    }
}
