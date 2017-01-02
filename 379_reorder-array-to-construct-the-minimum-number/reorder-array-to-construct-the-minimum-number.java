/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reorder-array-to-construct-the-minimum-number
@Language: Java
@Datetime: 16-11-16 22:49
*/

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return "";
        }
        
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(str, new StringComparator());
        
        String ans = "";
        for(int i = 0; i < str.length; i++){
            ans = ans.concat(str[i]);
        }
        
        int i = 0;
        while(i < nums.length && ans.charAt(i) == '0'){
            i++;
        }
        if(i == nums.length) return "0";
        
        return ans.substring(i);
    }
}

class StringComparator implements Comparator<String> {
    public int compare(String a, String b){
        String ab = a.concat(b);
        String ba = b.concat(a);
        return ab.compareTo(ba);
    }
}