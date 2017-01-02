```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Markdown
@Datetime: 16-12-29 02:43
```

//quick find 版本，无路径压缩
 
 public class Solution {
    class UnionFind{
        private int[] group;
        private int count;
        
        public UnionFind(int n){
            this.count = n;
            this.group = new int[n];
            for(int i = 0; i < n; i++){
                group[i] = i;
            }
        }
        
        public int count(){
            return count;
        }
        
        public boolean connected(int a, int b){
            return find(a) == find(b);
        }
        
        public int find(int p){
            return group[p];
        }
        
        public void union(int a, int b){
            int ida = find(a);
            int idb = find(b);
            
            if(ida == idb) return;
            
            for(int i = 0; i < group.length; i++){
                if(group[i] == ida){
                    group[i] = idb;
                }
            }
            count--;
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(edges.length != n - 1) return false;
        
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++){
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
                return false;
            }
            
            uf.union(edges[i][0], edges[i][1]);
        }
        
        return true;
    }
}