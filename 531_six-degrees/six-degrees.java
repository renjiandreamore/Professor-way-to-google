/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 16-09-27 04:55
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        int length = 0;
        // if(s.neighbors == null || s.neighbors.size() == 0){
        //     return -1;
        // }
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
        
        q.offer(s);
        hash.add(s);
        
        while(!q.isEmpty()){
            int size = q.size();
            length ++;
            for(int i = 0; i <size; i++ ){
                UndirectedGraphNode node = q.poll();
                if(node == t){
                    return length-1;
                }
                for(UndirectedGraphNode neighbor : node.neighbors){
                    if(hash.contains(neighbor)){
                        continue;
                    }
                    hash.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return -1 ;
    }
}