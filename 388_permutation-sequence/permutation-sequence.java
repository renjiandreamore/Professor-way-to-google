/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutation-sequence
@Language: Java
@Datetime: 16-12-18 05:22
*/

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        if(n < 1 || k < 1) return "";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i);
        }
        String s = sb.toString(); //"1234"
        
        //int num = Integer.parseInt(s); // 1234
        
        String next = s;
        for(int i = 1; i < k; i++){
            next = nextP(s);
            s = next;
        }
        
        return next;
    }
    
    public String nextP(String s){
        //12543 --> 13245
        int l = s.length()-1;
        for(int i = s.length()-1; i>=1; i--){
            if(Integer.parseInt(String.valueOf(s.charAt(i))) > Integer.parseInt(String.valueOf(s.charAt(i-1)))){
                l = i - 1;
                break;
            }
        }//found 2.
        
        if(l == s.length()-1){
            return reverse(s, 0, s.length()-1);
        }
        
        int r = s.length()-1;
        for(int i = s.length()-1; i>=l; i--){
            if(Integer.parseInt(String.valueOf(s.charAt(i))) > Integer.parseInt(String.valueOf(s.charAt(l)))){
                r = i;
                break;
            }
        }//found 3.
        
        String[] str = s.trim().split("");
        String tmp = str[l+1];
        str[l+1] = str[r+1];
        str[r+1] = tmp;
        
        String ss = "";
        for(int i = 1; i < str.length; i++) {
            ss+=str[i];
        }
        
        return reverse(ss, l+1, ss.length()-1);
    }
    
    public String reverse(String s, int start, int end){
        String[] strArr = s.split("");
        int left = start + 1;
        int right = end + 1;
        
        while(left < right){
            String tmp = strArr[left];
            strArr[left] = strArr[right];
            strArr[right] = tmp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr.length; i++){
            sb.append(strArr[i]);
        }
        
        return sb.toString();
    }
}
