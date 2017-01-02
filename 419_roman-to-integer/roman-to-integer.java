/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/roman-to-integer
@Language: Java
@Datetime: 16-11-24 16:43
*/

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        if(s == null || s.length() == 0)  return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = s.length();
        int ans = map.get(s.charAt(len - 1));
        
        for(int i = len - 2; i >= 0; i--){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans -= map.get(s.charAt(i));
            }else{
                ans += map.get(s.charAt(i));
            }
        }
        
        return ans;
    }
}