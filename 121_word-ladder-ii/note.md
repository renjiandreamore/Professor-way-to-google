```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Markdown
@Datetime: 16-12-19 17:44
```

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);
        return ladders;
        
    }
    
    void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict){
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for(String s: dict){
            map.put(s, new ArrayList<String>());
        }
        
        while(!q.isEmpty()){
            String word = q.poll();
            List<String> nextWords = getNextWord(word, dict);
            for(String next : nextWords){
                map.get(next).add(word);
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(word) + 1);
                    q.offer(next);
                }
            }
        }
    }
    
    void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance, Map<String, List<String>> map ){
        path.add(crt);
        if(crt == start){
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
            //return 为什么不能有return
        }
        for(String before: map.get(crt)){
            if(distance.get(crt) == distance.get(before)+1){
                dfs(ladders, path, before, start, distance, map);
            }
            //path.remove为什么不能写到这
        }
        path.remove(path.size()-1);
    }
    
    List<String> getNextWord(String crt, Set<String> dict){
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
}