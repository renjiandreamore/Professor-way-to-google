```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Markdown
@Datetime: 16-11-15 02:10
```

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Integer> pq  = new PriorityQueue<>(k, new pairCompr());
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pq.size()<k){
                    pq.offer(matrix[i][j]);
                }else{
                    if(matrix[i][j] < pq.peek()){
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        
        return pq.poll();
    }
    
}
class pairCompr implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return b - a;
    }
}