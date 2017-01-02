/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Java
@Datetime: 16-12-29 02:43
*/

public class Solution {
    class UnionFind{
        private int[] parent;
        private int count;
        
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        
        public int count(){
            return count;
        }
        
        public boolean connected(int a, int b){
            return find(a) == find(b);
        }
        
        public int find(int p){
            return compressed_find(p);
        }
        
        public int compressed_find(int p){
            int parent_p = parent[p];
            while(parent_p != parent[parent_p]){
                parent_p = parent[parent_p];
            }
            //路径压缩
            //这步没有也不影响结果
            int tmp = -1;
            int tmp_father = parent[p];
            while(tmp_father != parent[tmp_father]){
                tmp = parent[tmp_father];
                parent[tmp_father] = parent_p;
                tmp_father = tmp;
            }
            //end
            
            return parent_p;
        }
        
        public void union(int a, int b){
            int ida = find(a);
            int idb = find(b);
            
            if(ida == idb) return;
            
            parent[ida] = idb;
            count--;
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    // public boolean validTree(int n, int[][] edges) {
    //     // Write your code here
    //     if(edges.length != n - 1) return false;
        
    //     UnionFind uf = new UnionFind(n);
        
    //     for(int i = 0; i < edges.length; i++){
    //         if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
    //             return false;
    //         }
            
    //         uf.union(edges[i][0], edges[i][1]);
    //     }
        
    //     return true;
    // }
    
    
    //bfs version
    public boolean validTree(int n, int[][] edges){
        if(n - 1 != edges.length) return false;
        
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            neighbors.put(i, list);
        }
        
        for(int[] edge : edges){
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node]) return false;
            
            visited[node] = true;
            
            for(int i : neighbors.get(node)){
                if(!visited[i]){
                    q.offer(i);
                }
            }
        }
        
        for(boolean b : visited){
            if(!b) return false;
        }
        
        return true;
    }
}