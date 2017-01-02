/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/letter-combinations-of-a-phone-number
@Language: Java
@Datetime: 16-12-06 18:35
*/

public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        String sb = "";
        helper(digits, map, sb, res);
        
        return res;
    }
    
    public void helper(String digits, Map<Character, char[]> map, String sb, ArrayList<String> res){
        if(sb.length() == digits.length()){
            res.add(sb);
            return;
        }
        
        for(char c : map.get(digits.charAt(sb.length()))){
            sb += c;
            helper(digits, map, sb, res);
            sb = sb.substring(0, sb.length()-1);
        }
        
    }
}