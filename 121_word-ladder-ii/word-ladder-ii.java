/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 16-12-19 17:44
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> res = new ArrayList<>();
        if(dict == null){
            return res;
        }
        dict.add(start);
        dict.add(end);
        
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, List<String>> comesNodes = new HashMap<>();
        
        bfs(start, end, dict, distance, comesNodes);
        
        List<String> path = new ArrayList<>();
        dfs(res, path, end, start, distance, comesNodes);
        
        return res;
    }
    
    void bfs(String start, String end, Set<String> dict, HashMap<String, Integer> distance, HashMap<String, List<String>> comesNodes ){
        Queue<String> q = new LinkedList<>();
        for(String s : dict){
            comesNodes.put(s, new ArrayList<String>());
        }
        distance.put(start, 0);
        
        q.offer(start);
        
        while(!q.isEmpty()){
            String crt = q.poll();
            for(String next : getNextWords(crt, dict)){
                comesNodes.get(next).add(crt);
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(crt)+1);
                    q.offer(next);
                }
                
            }
        }
    }
    
    void dfs(List<List<String>> res, List<String> path, String crt, String start, HashMap<String, Integer> distance, HashMap<String, List<String>> comesNodes){
        path.add(crt);
        if(crt.equals(start)){
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }
        for(String before : comesNodes.get(crt)){
            if(distance.get(crt) == distance.get(before)+1){
                dfs(res, path, before, start, distance, comesNodes);
            }
        }
        path.remove(path.size()-1);
    }
    
    List<String> getNextWords(String s, Set<String> dict){
        List<String> res = new ArrayList<>();
        for(int i =0; i < s.length();i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(s.charAt(i) != c){
                    String newString = s.substring(0, i) + c + s.substring(i+1);
                    if(dict.contains(newString)){
                    res.add(newString);
                    }
                }
                
            }
        }
        return res;
    }
}