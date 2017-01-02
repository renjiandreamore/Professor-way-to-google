```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Markdown
@Datetime: 16-12-29 20:50
```

class Pair{
    String key;
    int val;
    public Pair(String key, int val){
        this.key = key;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     * 
     */
     Comparator<Pair> cmp = new Comparator<Pair>(){
         public int compare(Pair p1, Pair p2){
             if(p1.val != p2.val) return p2.val - p1.val;
             return p1.key.compareTo(p2.key);
         }
     };
     public String[] topKFrequentWords(String[] words, int k){
         if(words == null || words.length == 0){
             return null;
         }
         
         String[] res = new String[k];
         HashMap<String, Integer> map = new HashMap<>();
         Queue<Pair> queue = new PriorityQueue<Pair>(1000, cmp);
         
         for(String word : words){
             if(!map.containsKey(word)){
                 map.put(word, 1);
             }else{
                 map.put(word, map.get(word) + 1);
             }
         }
         
        Iterator iter = map.keySet().iterator(); // interator不安顺序
        int i = 0;
        while(iter.hasNext()){
            String key = (String)iter.next();  // iter.next()是object，要cast到string
            int value = map.get(key);
            Pair e = new Pair(key, value);
            queue.add(e);
            //i++;
        }
     
        int index = 0;
        while(!queue.isEmpty() && index < k){
            res[index++] = queue.poll().key;
        }
        
        return res;
}