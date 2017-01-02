```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Markdown
@Datetime: 16-09-23 17:34
```

if(node == null){
            return node;
        }
        
        //use BFS to get all the node 
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        //copy, store each old-new pair into HashMap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for(UndirectedGraphNode n : nodes){
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        //copy neighbors, get edges
        for(UndirectedGraphNode n : nodes){
            UndirectedGraphNode newNode = map.get(n);
            for(UndirectedGraphNode neighbor : n.neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
    
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        //HashSet<UndirectedGraphNode> set = new HashSet<>();
        ArrayList<UndirectedGraphNode> res = new ArrayList<UndirectedGraphNode>();
        
        Q.offer(node);
        res.add(node);
        while(!Q.isEmpty()){
            UndirectedGraphNode head = Q.poll();
            for(UndirectedGraphNode neighbor: head.neighbors){
                if(!res.contains(neighbor)){
                    Q.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;