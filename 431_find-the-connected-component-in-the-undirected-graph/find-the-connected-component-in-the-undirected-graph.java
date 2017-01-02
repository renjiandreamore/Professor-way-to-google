/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Java
@Datetime: 16-09-27 21:31
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nodes == null){
            return res;
        }
        //int size = nodes.size();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
        for(UndirectedGraphNode node : nodes){
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node : nodes){
            if(visited.get(node) == false){
                bfs(node, visited, res);
            }
        }
        return res;
    }
    void bfs(UndirectedGraphNode node, HashMap visited, List<List<Integer>> res){
        List<Integer> single = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        visited.put(node, true);
        
        while(!q.isEmpty()){
            UndirectedGraphNode head = q.poll();
            single.add(head.label);
            for(UndirectedGraphNode neighbor : head.neighbors){
                if(visited.get(neighbor) == false){
                    visited.put(neighbor, true);
                    q.offer(neighbor);
                }
            }
        }
        Collections.sort(single);
        res.add(single);
    }
}