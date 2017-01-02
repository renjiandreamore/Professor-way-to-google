/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/inverted-index
@Language: Java
@Datetime: 16-11-15 17:28
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<>();
        
        
        if(docs == null || docs.size()==0) {
            return map;
        }
        
        for(Document doc : docs){
            int id = doc.id;
            String[] words = doc.content.trim().split("\\s+");
            for(String word : words){
                if(!map.containsKey(word)){
                    List<Integer> posting = new ArrayList<>();
                    posting.add(id);
                    map.put(word, posting);
                }else{
                    List<Integer> list = map.get(word);
                    if(list.contains(id)) continue;
                    list.add(id);
                    map.put(word, list);
                }
            }
        }
        
        return map;
    }
}