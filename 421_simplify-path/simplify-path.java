/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/simplify-path
@Language: Java
@Datetime: 16-11-24 18:23
*/

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if(path == null || path.length() == 0) return "";
        
        String[] token = path.split("/+");
        List<String> p = new ArrayList<>();
        String res = "/";
        
        for(String s : token){
            if(s.equals("..")){
                if(p.size() > 0)
                    p.remove(p.size()-1);
            }
            else if(!s.equals(".")&& !s.equals("")){
                p.add(s);
            }
        }
        
        for(String s: p){
            res += s + "/";
        }
        
        if(res.length() > 1){
            res = res.substring(0, res.length()-1);
        }
        
        return res;
    }
}