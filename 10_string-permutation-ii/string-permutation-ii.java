/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-10-09 18:41
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        res.add(String.valueOf(ch));
        while( (ch = next(ch)) != null){
            res.add(String.valueOf(ch));
        }
        
        return res;
    }
    
    public char[] next(char[] st){
        int index = -1;
        for(int i = st.length - 1; i >0; i--){
            if(st[i] > st[i-1]){
                index = i-1;  //找到该变换的位置
                break;
            }
        }
        
        if(index < 0){
            return null;
        }
        
        for(int i = st.length - 1; i > index; i--){
            if(st[i] > st[index]){
                char tmp = st[i];
                st[i] = st[index];
                st[index] = tmp;
                break;
            }
        }
        
        reverse(st, index + 1, st.length - 1);
        return st;
    }
    
    public void reverse(char[] st, int s, int e){
        for(int i = s, j = e; i < j; i++, j--){
            char tmp = st[i];
            st[i] = st[j];
            st[j] = tmp;
        }
    }
}