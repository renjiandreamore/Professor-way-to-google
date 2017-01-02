/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 16-11-12 21:05
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        int i = a.length()-1;
        int j = b.length()-1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >=0 || j >= 0){
            int digitA = 0;
            int digitB = 0;
            if(i >= 0){
                digitA = a.charAt(i) - '0';
            }
            
            if(j >= 0){
                digitB = b.charAt(j) - '0';
            }
            
            int digit = digitA + digitB + add;
            add = 0;
            
            if( digit <= 1){
                sb.append(digit);
            }else{
                sb.append(digit-2);
                add=1;
            }
            i--;
            j--;
        }
        sb.append(add);
        
        
        
        String rs = reverse(sb.toString());
        return String.valueOf(Integer.parseInt(rs));
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
}