/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-09-23 18:49
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        
        //1. 先获得每个节点是多少个人的邻居
        for(DirectedGraphNode node : graph){  //不给出graph则写一个getnode() bfs
            for(DirectedGraphNode neighbor : node.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, 1);
                }else{
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }
        
        //2.找到不当邻居的那个(就是起点)
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                q.offer(node);
                res.add(node);
            }
        }
        
        //3.从头开始找neighbor，找到一个neighbor，数量-1，直到减到0，说明他不再是谁的neighbor(只是头)， 加入 res 和queue
        while(!q.isEmpty()){
            DirectedGraphNode head = q.poll();
            for(DirectedGraphNode nb : head.neighbors){
                map.put(nb, map.get(nb) - 1);
                if(map.get(nb) == 0){
                    res.add(nb);
                    q.offer(nb);
                }
            }
        }
        
        return res;
    }
}