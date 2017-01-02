/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Java
@Datetime: 16-11-16 17:00
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0) return res;
        
        // for(int i = 0; i < A.length; i++){
        //     int count = 0;
        //     for(int j = 0; j < i; j++){
        //         if(A[j] < A[i]){
        //             count ++;
        //         }
        //     }
        //     res.add(count);
        // }
        // return res;
        /*
        以上写法TLE
        */
        SegmentTree root = build(0, 100001);
        for(int i = 0; i < A.length; i++){
            int num = 0;
            if(A[i] > 0){
                num = query(root, 0, A[i] - 1);
            }
            modify(root, A[i], 1);
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
        if(index == root.start && index == root.end){
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
