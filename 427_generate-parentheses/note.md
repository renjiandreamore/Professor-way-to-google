```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Markdown
@Datetime: 16-12-01 03:30
```



public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        if(n <= 0) return res;
        
        if(n == 1){
            res.add("()");
            return res;
        }
        
        ArrayList<String> list = generateParenthesis(n-1);
        for(String s : list){
            String new1 = "()" + s;
            String new2 = s + "()";
            String new3 = "(" + s + ")";
            
            res.add(new1);
            res.add(new2);
            res.add(new3); 
        }
        if(n % 2 == 0){
            String new4 = "";
            for(int i = 1; i <= n / 2; i++){
                new4 += "(";
            }
            for(int i = 1; i <= n / 2; i++){
                new4 += ")";
            }
            
            new4 += new4;
            res.add(new4);
        }
        
        removeDup(res);
        return res;
    }
    
    public void removeDup(ArrayList<String> list){
        Map<String, Integer> map = new HashMap<>();
        for(String s : list){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s) + 1);
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            if(map.get(s) > 1){
                list.remove(s);
                map.put(s, map.get(s) - 1);
            }
        }
    }
    
    // public void helper(int n, String path, ArrayList<String> res){
    //     if(path.length() == 2 * n) {
    //         res.add(path);
    //         return;
    //     }
        
    //     path += "()";
    //     for(int i = 1; i <= n; i++){
            
    //     }
        
    // }
}