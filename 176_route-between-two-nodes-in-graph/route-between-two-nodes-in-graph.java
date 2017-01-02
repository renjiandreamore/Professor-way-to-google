/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/route-between-two-nodes-in-graph
@Language: Java
@Datetime: 16-11-05 22:08
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if(graph == null || graph.size()==0 || !graph.contains(s) || !graph.contains(t)) return false;
        
        HashSet<DirectedGraphNode> set = new HashSet<>();
        Queue<DirectedGraphNode> q = new LinkedList<>();
        
        q.offer(s);
        set.add(s);
        
        while(!q.isEmpty()){
            DirectedGraphNode head = q.poll();
            if(head == t){
                return true;
            }
            for(DirectedGraphNode node : head.neighbors){
                if(!set.contains(node)){
                    set.add(node);
                    q.offer(node);
                    
                }
            }
        }
        
        return false;
    }
}