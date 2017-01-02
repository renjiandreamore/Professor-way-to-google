/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/restore-ip-addresses
@Language: Java
@Datetime: 16-12-16 00:17
*/

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        
        if(s == null || s.length() < 4 || s.length() > 12 ){
            return res;
        }
        
        dfs(s, 0, path, res);
        return res;
    }
    
    public void dfs(String s, int index, ArrayList<String> path, ArrayList<String> res){
        if(path.size() == 4){
            if(index != s.length()){
                return;
            }
            
            StringBuffer sb = new StringBuffer();
            for(String st : path){
                sb.append(st);
                sb.append(".");
            }
            
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        
        for(int i = index; i < index + 3 && i < s.length(); i++){
            String tmp = s.substring(index, i + 1);
            if(isValid(tmp)){
                path.add(tmp);
                dfs(s, i + 1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}