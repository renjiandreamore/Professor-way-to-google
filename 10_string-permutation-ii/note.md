```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Markdown
@Datetime: 16-10-09 18:41
```

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        
        if(str == null){
            return res;
        }
        
        if(str.length() == 0) {
            res.add(new String());
            return res;
        }
        
        str = sortString(str);
        
        String word = "";
        
        int[] visited = new int[str.length()];
        for(int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
        
        
        helper(res, word, str, visited);
        return res;
    }
    
    public void helper(List<String> res, String word, String str, int[] visited){
        //char[] charStr = str.toCharArray();
        
        if(word.length() == str.length()){
            res.add(word);
            return;
        }     
         
        
        //ArrayList<Character> path = new ArrayList<>();
        
        for(int i = 0; i < str.length();i++){
            // if(contain(word, str.charAt(i))){
            //     continue;
            // }
            //这一部分要找abc这样没有重复的时候可以，abb这样有重复的时候就永远加不进去结果res 
            if(visited[i]==1  || (i!=0 && str.charAt(i)==str.charAt(i-1) && visited[i-1] == 0 )){
                continue;
            }
            
            visited[i] = 1;
            word += str.charAt(i);
            helper(res, word, str, visited);
            word = word.substring(0,word.length()-1);
            visited[i] = 0;
        }
    }
    
    // public boolean contain(String word, Character c){
    //     char[] ch = word.toCharArray();
    //     for(int i = 0; i < ch.length; i++){
    //         if(ch[i] == c){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    public String sortString(String word){
        char [] c = word.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        return s;
    }
}