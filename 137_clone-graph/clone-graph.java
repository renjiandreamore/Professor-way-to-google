/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 16-09-23 17:34
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return null;
        }
        
        //bfs get all the nodes
        ArrayList<UndirectedGraphNode> allNodes = getNodes(node);
        
        //make old - new node pairs int hash
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for(UndirectedGraphNode n : allNodes){
            UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
            if(!map.containsKey(n)){
                map.put(n, newNode);
            }
        }
        
        //get the neighbors(edges)
        for(UndirectedGraphNode n1 : allNodes){
            UndirectedGraphNode pairNode = map.get(n1);
            ArrayList<UndirectedGraphNode> neighbors = n1.neighbors;
            for(UndirectedGraphNode neighbor : neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor); //得到neighbor的镜像，加到pair的neighbor里
                pairNode.neighbors.add(newNeighbor); 
            }
        }
        return map.get(node);
    }
    
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> res = new ArrayList<>();
        
        Q.offer(node);
        res.add(node);
        
        while(!Q.isEmpty()){
            UndirectedGraphNode head = Q.poll();
            for(UndirectedGraphNode neighbor : head.neighbors){
                if(!res.contains(neighbor)){
                    res.add(neighbor);
                    Q.offer(neighbor);
                }
            }
        }
        return res;
    }
}