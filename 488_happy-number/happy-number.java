/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 16-12-23 01:54
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        // Write your code here
        int sum = function(n);
        if(sum == 1) return true;
        if(sum != 1 && !set.contains(sum)){
            set.add(sum);
        }
        else if(set.contains(sum)){
            return false;
        }
        return isHappy(sum);
    }
    
    public int function(int n){
        String s = String.valueOf(n);
        int rs = 0;
        for(int i = 0; i < s.length(); i++){
            rs += (Integer.parseInt(s.substring(i,i+1)) * Integer.parseInt(s.substring(i,i+1)));
        }
        return rs;
    }
}