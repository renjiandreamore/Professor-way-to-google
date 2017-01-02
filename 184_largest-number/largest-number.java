/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 16-11-05 23:36
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return "";
        }
        
        int len = num.length;
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(str, new strComparator());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        
        return sb.toString();
    }
}

class strComparator implements Comparator<String>{
    public int compare(String a, String b){
        return (b+a).compareTo(a+b);
    }
}