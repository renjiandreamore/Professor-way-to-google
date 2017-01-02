/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Java
@Datetime: 16-11-15 02:10
*/

class Pair{
    int i;
    int j;
    int val;
    public Pair(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.val - b.val;
    }
}



public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        //note里有brute解法 
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(1, new PairComparator());
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0,1};
        int[] dy = {1,0};
        
        pq.offer(new Pair(0,0,matrix[0][0]));
        
        for(int i = 0; i < k - 1; i++){
            Pair head = pq.poll();
            for(int j = 0; j < 2; j++){  //2 == dx||dy.length;
                int next_i = head.i + dx[j];
                int next_j = head.j + dy[j];
                
                if(next_i < m && next_j < n && !visited[next_i][next_j]){
                    //next.val = matrix[next_i][next_j];
                    Pair next = new Pair(next_i, next_j, matrix[next_i][next_j]);
                    visited[next_i][next_j] = true;
                    pq.offer(next);
                }
            }
        }
        return pq.poll().val;
    }
}

