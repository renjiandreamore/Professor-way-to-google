/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Java
@Datetime: 16-10-25 02:09
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if(source == null || source.length() == 0) return "";
        HashMap<Character, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < target.length();i++){
            if(!hash.containsKey(target.charAt(i))){
                hash.put(target.charAt(i), 1);
            }
            else{
                hash.put(target.charAt(i), hash.get(target.charAt(i)) + 1);
            }
        }
        
        int left = 0, minLength = source.length() + 1, minStart = 0;
        int minEnd = 0;
        int count = 0;
        
        for(int right = 0; right < source.length(); right ++){
            if(hash.containsKey(source.charAt(right))){
                hash.put(source.charAt(right), hash.get(source.charAt(right)) -1);
                
                //count ++;
                if(hash.get(source.charAt(right)) >= 0) count++;
                //s="adobeac"   t="abc"   not add 2nd 'a' in  count window;
                
                while(count == target.length()){
                    
                    if(right - left + 1 < minLength){
                        minLength = right - left + 1;
                        minStart = left;
                        minEnd = right;
                    }
                    
                    
                    if(hash.containsKey(source.charAt(left))){
                        hash.put(source.charAt(left), hash.get(source.charAt(left)) + 1);
                        
                        if(hash.get(source.charAt(left)) > 0){
                            count --;
                            //s = "adaaaaabeoc" t = "abc" , when remove 1st a, because 
                            //there is still 'a' later, so not deduct count
                        }
                        //count --;
                    }
                    
                    left++;
                }
            }
        }
        
        if(minLength > source.length()) return "";
        
        return source.substring(minStart, minEnd + 1); //minStart + minLength);
    }
}