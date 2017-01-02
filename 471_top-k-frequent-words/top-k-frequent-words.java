/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-12-29 20:50
*/

class Pair{
    String key;
    int value;
    public Pair(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     * 
     */
     
     private Comparator<Pair> pairComparator = new Comparator<Pair>() {
        public int compare(Pair left, Pair right) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            return right.key.compareTo(left.key);
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(k, pairComparator);
        for (String word : counter.keySet()) {
            Pair peak = Q.peek();
            Pair newPair = new Pair(word, counter.get(word));
            if (Q.size() < k) {
                Q.offer(newPair);
            } else if (pairComparator.compare(newPair, peak)>0) {
                Q.poll();
                Q.offer(newPair);
            }
        } //这个解决办法是先把最小的comparator排在最前面，然后找到比poll出来的大的代替poll的，加入quque里。最后再反转
        
        String[] result = new String[k];
        int index = 0;
        while (!Q.isEmpty()) {
            result[index++] = Q.poll().key;
        }
        
        // reverse
        for (int i = 0; i < index / 2; i++) {
            String temp = result[i];
            result[i] = result[index - i - 1];
            result[index - i - 1] = temp;
        }
        
        return result;
     
    //  Comparator<Pair> cmp = new Comparator<Pair>(){
    //      public int compare(Pair p1, Pair p2){
    //          if(p1.val != p2.val) return p2.val - p1.val;
    //          return p1.key.compareTo(p2.key);
    //      }
    //  };
    //  public String[] topKFrequentWords(String[] words, int k){
    //      if(words == null || words.length == 0){
    //          return null;
    //      }
         
    //      String[] res = new String[k];
    //      HashMap<String, Integer> map = new HashMap<>();
    //      Queue<Pair> queue = new PriorityQueue<Pair>(10000, cmp);
         
    //      for(String word : words){
    //          if(!map.containsKey(word)){
    //              map.put(word, 1);
    //          }else{
    //              map.put(word, map.get(word) + 1);
    //          }
    //      }
         
    //     Iterator iter = map.keySet().iterator(); // interator不安顺序
    //     int i = 0;
    //     while(iter.hasNext()){
    //         String key = (String)iter.next();  // iter.next()是object，要cast到string
    //         int value = map.get(key);
    //         Pair e = new Pair(key, value);
    //         queue.add(e);
    //         //i++;
    //     }
     
    //     int index = 0;
    //     while(!queue.isEmpty() && index < k){
    //         res[index++] = queue.poll().key;
    //     }
        
    //     return res;
     
     
     
//     Comparator<HashMap<String, Integer>> mapComparator = new Comparator<HashMap<String, Integer>>(){
//     	public int compare(HashMap<String, Integer > m1, HashMap<String, Integer> m2){
//     		return m1.values() - m2.values(); 
//     	}
//     };
    
//     public String[] topKFrequentWords(String[] words, int k) {
//         // Write your code here
//         // Write your code here
//         if(words == null || words.length == 0){
//             return null;
//         }
        
//         String[] res = new String[k];
//         HashMap<String, Integer> map = new HashMap<String, Integer>();
        
//         Queue<HashMap<String, Integer>> queue = new PriorityQueue<HashMap<String, Integer>>(1000, mapComparator);
        
//         for(int i = 0; i < words.length; i++){
//             if(!map.containsKey(words[i])){
//                 map.put(words[i], 1);
//             }else{
//                 int count = map.get(words[i]);
//                 count++;
//                 map.remove(words[i]);
//                 map.put(words[i], count);
//             }
//             queue.add(map);
//         }
        
// //        Iterator iter = map.keySet().iterator();
// //        while(iter.hasNext()){
// //            String key = (String)iter.next();  // iter.next()是object，要cast到string
// //            int value = map.get(key);
// //            queue.add(value);
// //        }
//         Set<String> set = new HashSet<String>();
//         set = (queue.poll().keySet());
        
//         for(int i = 0; i < k; i ++){
//             res[i] = set.toString();
//         }
        
//         return res;
    }
}